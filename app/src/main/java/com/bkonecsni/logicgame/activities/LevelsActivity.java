package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkonecsni.logicgame.adapters.LevelsAdapter;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.util.GameUtil;
import com.bkonecsni.logicgame.util.IconProvider;
import com.bkonecsni.logicgame.util.StringService;

import logicgame.bkonecsni.com.logicgame.R;

public class LevelsActivity extends AppCompatActivity {

    public static final String GAME_NAME = "gameName";
    public static final String LEVEL_NUMBER = "levelName";

    private static Context context;

    private GridView levelsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        LevelsActivity.context = getApplicationContext();

        AbstractGameInfo gameInfo = GameUtil.getGameInfo(getIntent().getStringExtra(GAME_NAME));
        levelsView = findViewById(R.id.levels);
        addOnClickListener(levelsView, gameInfo);
        ((LevelsAdapter) levelsView.getAdapter()).notifyDataSetChanged();
        setupHeader(gameInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LevelsAdapter) levelsView.getAdapter()).notifyDataSetChanged();
    }

    private void setupHeader(AbstractGameInfo gameInfo) {
        String gameName = gameInfo.getGameName();
        setGameIcon(context, gameName);
        setGameTitle(gameName);
        addLinkToHome(context);
        addLinkToGames(context);
    }

    private void addOnClickListener(GridView levelsView, AbstractGameInfo gameInfo) {
        levelsView.setAdapter(new LevelsAdapter(gameInfo.getMaps(), gameInfo.getGameName()));

        levelsView.setOnItemClickListener((parent, v, position, id) -> {
            ((LevelsAdapter) levelsView.getAdapter()).notifyDataSetChanged();
            startMapActivity(position);
        });
    }

    private void startMapActivity(int position) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(GAME_NAME, getIntent().getStringExtra(GAME_NAME));
        intent.putExtra(LEVEL_NUMBER, position);

        startActivity(intent);
    }

    private void setGameIcon(Context context, String gameName) {
        ImageView gameIcon = findViewById(R.id.gameIcon);
        String iconName = gameName + "_icon";

        int icon = IconProvider.getDrawable(context, iconName);
        gameIcon.setImageIcon(Icon.createWithResource(context, icon));
    }

    private void setGameTitle(String gameName) {
        TextView title = findViewById(R.id.title);
        title.setText(StringService.getFormattedTitle(gameName));
    }

    private void addLinkToHome(Context context) {
        ImageView homeLink = findViewById(R.id.homeLink);

        homeLink.setOnClickListener(v -> {
            Intent intent = new Intent(context, HomeActivity.class);
            startActivity(intent);
        });
    }

    private void addLinkToGames(Context context) {
        ImageView gamesLink = findViewById(R.id.gamesLink);

        gamesLink.setOnClickListener(v -> {
            Intent intent = new Intent(context, GamesActivity.class);
            startActivity(intent);
        });
    }

    public static Context getAppContext() {
        return LevelsActivity.context;
    }
}
