package com.bkonecsni.logicgame.adapters;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bkonecsni.logicgame.activities.LevelsActivity;
import com.bkonecsni.logicgame.domain.map.LevelBase;

import java.util.Arrays;
import java.util.List;

public class LevelsAdapter extends BaseAdapter {

    private List<LevelBase> levelList;
    private String gameName;

    public LevelsAdapter(List<LevelBase> levelList, String gameName) {
        this.levelList = levelList;
        this.gameName = gameName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView == null) {
            textView = new TextView(parent.getContext());
            textView.setText(String.valueOf(position + 1));
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(200, 200);
            textView.setLayoutParams(layoutParams);
            textView.setPadding(16, 16, 16, 16);
            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        } else {
            textView = (TextView) convertView;
        }

        if (LevelsActivity.getAppContext() != null) {
            setBackgroundColor(position, textView);
        }

        return textView;
    }

    private void setBackgroundColor(int position, TextView textView) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LevelsActivity.getAppContext());
        String solvedLevels = preferences.getString(gameName, "");

        List<String> solvedLevelsList = Arrays.asList(solvedLevels.split(","));

        if (solvedLevelsList.contains(String.valueOf(position ))) {
            textView.setBackgroundColor(Color.GREEN);
        } else {
            textView.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public int getCount() {
        return levelList.size();
    }

    @Override
    public Object getItem(int position) {
        return levelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setLevelList(List<LevelBase> levelList) {
        this.levelList = levelList;
    }
}
