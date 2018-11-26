package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.bkonecsni.logicgame.adapters.MapAdapter;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.util.GameUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import logicgame.bkonecsni.com.logicgame.R;

import static com.bkonecsni.logicgame.activities.LevelsActivity.GAME_NAME;
import static com.bkonecsni.logicgame.activities.LevelsActivity.LEVEL_NUMBER;

public class MapActivity extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapActivity.context = getApplicationContext();
        setContentView(R.layout.activity_map);
        GridView mapView = findViewById(R.id.map);

        int levelNumber = getIntent().getIntExtra(LEVEL_NUMBER, 1);
        String gameName = getIntent().getStringExtra(GAME_NAME);
        LevelBase level = GameUtil.getLevel(gameName, levelNumber);
        AbstractGameInfo gameInfo = GameUtil.getGameInfo(gameName);

        setColumnNumber(mapView, levelNumber, gameInfo);
        setTitle(gameName);
        setLevelNumber(levelNumber + 1);

        addOnClickListener(mapView, level, gameInfo, levelNumber);
    }

    private void addOnClickListener(GridView mapView, LevelBase level, AbstractGameInfo gameInfo, int levelNumber) {
        mapView.setAdapter(new MapAdapter(level.getTileList(), gameInfo));
        mapView.setOnItemClickListener((parent, v, position, id) -> {
            level.getTile(position).handleState();
            ((MapAdapter) mapView.getAdapter()).setTileList(level.getTileList());
            ((MapAdapter) mapView.getAdapter()).notifyDataSetChanged();

            if (gameInfo.getValidationHandler().areWinConditionsApply(level)) {
                Toast.makeText(context, "You won!", Toast.LENGTH_SHORT).show();

                markLevelAsSolved(gameInfo, levelNumber);
            }
        });
    }

    private void markLevelAsSolved(AbstractGameInfo gameInfo, int levelNumber) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LevelsActivity.getAppContext());//this.getPreferences(Context.MODE_PRIVATE);

        String solvedLevels = sharedPref.getString(gameInfo.getGameName(), "");
        List<String> solvedLevelsList = Arrays.asList(solvedLevels.split(","));

        if (!solvedLevelsList.contains(String.valueOf(levelNumber))) {
            addLevelToSharedPref(gameInfo, levelNumber, sharedPref, solvedLevels);
        }
    }

    private void addLevelToSharedPref(AbstractGameInfo gameInfo, int levelNumber, SharedPreferences sharedPref, String solvedLevels) {
        if (!solvedLevels.isEmpty()) {
            solvedLevels += ",";
        }

        solvedLevels += levelNumber;

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(gameInfo.getGameName(), solvedLevels);
        editor.commit();
    }

    private void setLevelNumber(int levelNumber) {
        TextView levelNumberTextView = findViewById(R.id.levelNumber);
        levelNumberTextView.setText("Level " + levelNumber);
    }

    private void setTitle(String gameName) {
        TextView gameTitleTextView = findViewById(R.id.gameTitle);
        gameTitleTextView.setText(StringUtils.capitalize(gameName ));
    }

    private void setColumnNumber(GridView mapView, int levelNumber, AbstractGameInfo gameInfo) {
        int columnNumber = gameInfo.getMaps().get(levelNumber).getColumnNumber();
        mapView.setNumColumns(columnNumber);
    }

    public static Context getAppContext() {
        return MapActivity.context;
    }
}
