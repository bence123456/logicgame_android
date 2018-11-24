package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import com.bkonecsni.logicgame.adapters.MapAdapter;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.util.GameUtil;

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

        int columnNumber = gameInfo.getMaps().get(levelNumber).getColumnNumber();
        mapView.setNumColumns(columnNumber);

        mapView.setAdapter(new MapAdapter(level.getTileList(), gameInfo));
        mapView.setOnItemClickListener((parent, v, position, id) -> {
            level.getTile(position).handleState();
            ((MapAdapter) mapView.getAdapter()).setTileList(level.getTileList());
            ((MapAdapter) mapView.getAdapter()).notifyDataSetChanged();

            if (gameInfo.getValidationHandler().areWinConditionsApply(level)) {
                Toast.makeText(context, "You won!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static Context getAppContext() {
        return MapActivity.context;
    }
}
