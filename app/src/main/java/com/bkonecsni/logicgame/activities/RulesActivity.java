package com.bkonecsni.logicgame.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.bkonecsni.logicgame.util.StringService;

import logicgame.bkonecsni.com.logicgame.R;

import static com.bkonecsni.logicgame.activities.LevelsActivity.GAME_NAME;
import static com.bkonecsni.logicgame.activities.LevelsActivity.getAppContext;

public class RulesActivity extends AppCompatActivity {

    public static final String DEFAULT_PACKAGE = "logicgame.bkonecsni.com.logicgame";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        String gameName = getIntent().getStringExtra(GAME_NAME);
        setRulesTitle(gameName);

        Context appContext = getAppContext();
        setSummaryText(gameName, appContext);
        setRulesText(gameName, appContext);
    }

    private void setRulesTitle(String gameName) {
        TextView rulesTitle = findViewById(R.id.rulesTitle);
        rulesTitle.setText("Rules for " + StringService.getFormattedTitle(gameName));
    }

    private void setRulesText(String gameName, Context appContext) {
        TextView rules = findViewById(R.id.rules);
        rules.setMovementMethod(new ScrollingMovementMethod());

        int rulesResId = appContext.getResources().getIdentifier(gameName+"_rules", "string", DEFAULT_PACKAGE);
        rules.setText(appContext.getString(rulesResId));
    }

    private void setSummaryText(String gameName, Context appContext) {
        TextView summary = findViewById(R.id.summary);
        int summaryResId = appContext.getResources().getIdentifier(gameName+"_summary", "string", DEFAULT_PACKAGE);
        summary.setText(appContext.getString(summaryResId));
    }
}
