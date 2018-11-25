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

import org.apache.commons.lang3.StringUtils;

import logicgame.bkonecsni.com.logicgame.R;

public class LevelsActivity extends AppCompatActivity {

    public static final String GAME_NAME = "gameName";
    public static final String LEVEL_NUMBER = "levelName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        AbstractGameInfo gameInfo = GameUtil.getGameInfo(getIntent().getStringExtra(GAME_NAME));
        GridView levelsView = findViewById(R.id.levels);
        addOnClickListener(levelsView, gameInfo);

        setupHeader(gameInfo);
    }

    private void setupHeader(AbstractGameInfo gameInfo) {
        Context context = getApplicationContext();
        String gameName = gameInfo.getGameName();
        setGameIcon(context, gameName);
        setGmaeTitle(gameName);
        addLinkToHome(context);
    }

    private void addOnClickListener(GridView levelsView, AbstractGameInfo gameInfo) {
        levelsView.setAdapter(new LevelsAdapter(gameInfo.getMaps()));

        levelsView.setOnItemClickListener((parent, v, position, id) -> {
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
        ImageView imageView = findViewById(R.id.imageView);
        String iconName = gameName + "_icon";

        int icon = IconProvider.getDrawable(context, iconName);
        imageView.setImageIcon(Icon.createWithResource(context, icon));
    }

    private void setGmaeTitle(String gameName) {
        TextView title = findViewById(R.id.title);
        title.setText(StringUtils.capitalize(gameName));
    }

    private void addLinkToHome(Context context) {
        ImageView homeLink = findViewById(R.id.homeLink);

        int icon = IconProvider.getDrawable(getApplicationContext(), "home_icon");
        homeLink.setImageIcon(Icon.createWithResource(context, icon));

        homeLink.setOnClickListener(v -> {
            Intent intent = new Intent(context, HomeActivity.class);
            startActivity(intent);
        });
    }
}
