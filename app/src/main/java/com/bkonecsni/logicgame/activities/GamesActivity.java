package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bkonecsni.logicgame.adapters.GamesAdapter;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.gamecode.parks.ParksGameInfo;
import com.bkonecsni.logicgame.util.GameUtil;

import java.util.Arrays;
import java.util.List;

import logicgame.bkonecsni.com.logicgame.R;

public class GamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Context context = this;

        RecyclerView gameList = findViewById(R.id.gameList);
        gameList.setLayoutManager(new LinearLayoutManager(context));
        gameList.setHasFixedSize(true);

        List<AbstractGameInfo> gameInfoList = GameUtil.getInstance().getGameInfoList();
        gameList.setAdapter(new GamesAdapter(gameInfoList));
    }
}
