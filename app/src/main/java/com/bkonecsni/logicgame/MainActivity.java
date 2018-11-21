package com.bkonecsni.logicgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.bkonecsni.logicgame.gamecode.parks.ParksGameInfo;
import com.bkonecsni.logicgame.gamecode.parks.levels.Level1;

import logicgame.bkonecsni.com.logicgame.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView mapView = findViewById(R.id.map);

        ParksGameInfo parksGameInfo = new ParksGameInfo();
        parksGameInfo.init();

        Level1 parks = (Level1) parksGameInfo.getMaps().get(0);

        mapView.setAdapter(new MapAdapter(parks.getTileList()));
        mapView.setOnItemClickListener((parent, v, position, id) -> {
            parks.getTile(position).handleState();
            ((MapAdapter) mapView.getAdapter()).tileList = parks.getTileList();
            ((MapAdapter) mapView.getAdapter()).notifyDataSetChanged();
        });
    }

    private int log(View v) {
        return Log.d("MainActivity: ", String.valueOf(v.getId()));
    }
}
