package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bkonecsni.logicgame.adapters.MapAdapter;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.util.GameUtil;
import com.bkonecsni.logicgame.util.IconProvider;
import com.bkonecsni.logicgame.util.StringService;

import java.util.Arrays;
import java.util.List;

import logicgame.bkonecsni.com.logicgame.R;

import static com.bkonecsni.logicgame.activities.LevelsActivity.GAME_NAME;
import static com.bkonecsni.logicgame.activities.LevelsActivity.LEVEL_NUMBER;

public class MapActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_map);
        GridView mapView = findViewById(R.id.map);

        int levelNumber = getIntent().getIntExtra(LEVEL_NUMBER, 1);
        String gameName = getIntent().getStringExtra(GAME_NAME);
        LevelBase level = GameUtil.getLevel(gameName, levelNumber);
        AbstractGameInfo gameInfo = GameUtil.getGameInfo(gameName);
        setColumnNumber(mapView, levelNumber, gameInfo);

        setUpHeader(levelNumber, gameName);
        addListenerForMap(mapView, level, gameInfo, levelNumber);
        addListenerForFooter(mapView, levelNumber, level, gameInfo);
    }

    private void setUpHeader(int levelNumber, String gameName) {
        setGameIcon(gameName);
        setTitle(gameName);
        setLevelNumber(levelNumber + 1);
    }

    private void addListenerForFooter(GridView mapView, int levelNumber, LevelBase level, AbstractGameInfo gameInfo) {
        addListenerForLevels(gameInfo);
        addListenerForRules();
        addListenerForRestart(mapView, level);
        addListenerForNextLevel(levelNumber, gameInfo);
    }

    private void addListenerForLevels(AbstractGameInfo gameInfo) {
        ImageView levelsImage = findViewById(R.id.levels);
        levelsImage.setOnClickListener(v -> {
            Intent intent = new Intent(context, LevelsActivity.class);
            intent.putExtra("gameName", gameInfo.getGameName());
            context.startActivity(intent);
        });
    }

    private void addListenerForRules() {
        ImageView rulesImage = findViewById(R.id.rules);
        rulesImage.setOnClickListener(v -> {
            Intent intent = new Intent(context, RulesActivity.class);
            intent.putExtra(GAME_NAME, getIntent().getStringExtra(GAME_NAME));
            context.startActivity(intent);
        });
    }

    private void addListenerForNextLevel(int levelNumber, AbstractGameInfo gameInfo) {
        ImageView nextLevelImage = findViewById(R.id.nextLevel);
        nextLevelImage.setOnClickListener(v -> {
            if (gameInfo.getMaps().size() == levelNumber + 1) {
                Toast.makeText(context, "The current level is the last one in this game!", Toast.LENGTH_SHORT).show();
            } else {
                startNextLevel(levelNumber);
            }
        });
    }

    private void startNextLevel(int levelNumber) {
        Intent intent = new Intent(context, MapActivity.class);
        intent.putExtra(GAME_NAME, getIntent().getStringExtra(GAME_NAME));
        intent.putExtra(LEVEL_NUMBER, levelNumber + 1);

        context.startActivity(intent);
    }

    private void addListenerForRestart(GridView mapView, LevelBase level) {
        ImageView restartImage = findViewById(R.id.restart);
        restartImage.setOnClickListener(v -> {
            level.init();
            refreshAdapter(mapView, level);
        });
    }

    private void addListenerForMap(GridView mapView, LevelBase level, AbstractGameInfo gameInfo, int levelNumber) {
        mapView.setAdapter(new MapAdapter(level.getTileList(), gameInfo));
        mapView.setOnItemClickListener((parent, v, position, id) -> {
            level.getTile(position).handleState();
            refreshAdapter(mapView, level);

            if (gameInfo.getValidationHandler().areWinConditionsApply(level)) {
                showToast();

                markLevelAsSolved(gameInfo, levelNumber);
            }
        });
    }

    private void refreshAdapter(GridView mapView, LevelBase level) {
        ((MapAdapter) mapView.getAdapter()).setTileList(level.getTileList());
        ((MapAdapter) mapView.getAdapter()).notifyDataSetChanged();
    }

    private void showToast() {
        Toast toast = Toast.makeText(context, "Level solved!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 150);

        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.green, null), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(Color.BLACK);

        toast.show();
    }

    private void markLevelAsSolved(AbstractGameInfo gameInfo, int levelNumber) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LevelsActivity.getAppContext());

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
        levelNumberTextView.setText(String.valueOf(levelNumber));
    }

    private void setGameIcon(String gameName) {
        ImageView gameIcon = findViewById(R.id.gameIcon);
        String iconName = gameName + "_icon";

        int icon = IconProvider.getDrawable(context, iconName);
        gameIcon.setImageIcon(Icon.createWithResource(context, icon));
    }

    private void setTitle(String gameName) {
        TextView gameTitleTextView = findViewById(R.id.gameTitle);
        gameTitleTextView.setText(StringService.getFormattedTitle(gameName));
    }

    private void setColumnNumber(GridView mapView, int levelNumber, AbstractGameInfo gameInfo) {
        int columnNumber = gameInfo.getMaps().get(levelNumber).getColumnNumber();
        mapView.setNumColumns(columnNumber);
    }
}
