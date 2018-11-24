package com.bkonecsni.logicgame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.util.GameUtil;

import logicgame.bkonecsni.com.logicgame.R;

public class LevelsActivity extends AppCompatActivity {

    public static final String GAME_NAME = "gameName";
    public static final String LEVEL_NUMBER = "levelName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(GAME_NAME, getIntent().getStringExtra(GAME_NAME));
        // TODO: uiról indexelés mehet 0tól
        intent.putExtra(LEVEL_NUMBER, 1);

        startActivity(intent);
        AbstractGameInfo gameInfo = GameUtil.getGameInfo(getIntent().getStringExtra(GAME_NAME));
    }
}
