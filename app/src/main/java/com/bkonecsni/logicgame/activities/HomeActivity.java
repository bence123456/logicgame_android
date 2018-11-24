package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import logicgame.bkonecsni.com.logicgame.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Context context = this;

        View gamesButton = findViewById(R.id.gamesButton);
        gamesButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, GamesActivity.class);
            startActivity(intent);
        });

        View aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, AboutActivity.class);
            startActivity(intent);
        });
    }



}
