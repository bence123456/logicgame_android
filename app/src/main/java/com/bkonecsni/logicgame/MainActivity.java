package com.bkonecsni.logicgame;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.gamecode.parks.ParksGameInfo;

import java.util.Arrays;
import java.util.List;

import logicgame.bkonecsni.com.logicgame.R;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);

        GridView mapView = findViewById(R.id.map);
        List<AbstractGameInfo> gameInfoList = getGameInfoList();

        for (AbstractGameInfo gameInfo : gameInfoList) {
            gameInfo.init();
            LevelBase level1 = gameInfo.getMaps().get(0);

            mapView.setAdapter(new MapAdapter(level1.getTileList(), gameInfo));
            mapView.setOnItemClickListener((parent, v, position, id) -> {
                level1.getTile(position).handleState();
                ((MapAdapter) mapView.getAdapter()).tileList = level1.getTileList();
                ((MapAdapter) mapView.getAdapter()).notifyDataSetChanged();
            });
        }

    }

    // TODO: iter through packages in gamecode and load every gameinfo
    private List<AbstractGameInfo> getGameInfoList() {
        return Arrays.asList(new ParksGameInfo());
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }
}
