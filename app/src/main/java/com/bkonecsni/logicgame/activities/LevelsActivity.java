package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra(GAME_NAME, getIntent().getStringExtra(GAME_NAME));
        // TODO: uiról indexelés mehet 0tól
        intent.putExtra(LEVEL_NUMBER, 1);

        startActivity(intent);
        AbstractGameInfo gameInfo = GameUtil.getGameInfo(getIntent().getStringExtra(GAME_NAME));


        Context context = setGameIcon(gameInfo);
        setGmaeTitle(gameInfo);
        addLinkToHome(context);
    }

    @NonNull
    private Context setGameIcon(AbstractGameInfo gameInfo) {
        ImageView imageView = findViewById(R.id.imageView);
        String iconName = gameInfo.getGameName() + "_icon";
        Context context = getApplicationContext();
        int icon = IconProvider.getDrawable(context, iconName);
        imageView.setImageIcon(Icon.createWithResource(context, icon));
        return context;
    }

    private void setGmaeTitle(AbstractGameInfo gameInfo) {
        TextView title = findViewById(R.id.title);
        title.setText(StringUtils.capitalize(gameInfo.getGameName()));
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
