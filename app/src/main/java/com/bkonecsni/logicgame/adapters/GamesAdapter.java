package com.bkonecsni.logicgame.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkonecsni.logicgame.activities.LevelsActivity;
import com.bkonecsni.logicgame.activities.MapActivity;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.util.IconProvider;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import logicgame.bkonecsni.com.logicgame.R;

public class GamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AbstractGameInfo> gameInfoList;

    private Context context;

    public GamesAdapter(List<AbstractGameInfo> gameInfoList) {
        this.gameInfoList = gameInfoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        AbstractGameInfo gameInfo = gameInfoList.get(i);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LevelsActivity.class);
                intent.putExtra("gameName", gameInfo.getGameName());
                context.startActivity(intent);
            }
        });


        ImageView imageView = viewHolder.itemView.findViewById(R.id.imageView);
        String iconName = gameInfo.getGameName() + "_icon";
        int icon = IconProvider.getDrawable(context, iconName);
        imageView.setImageIcon(Icon.createWithResource(context, icon));
//        imageView.setImageDrawable(Drawable.createFromPath(iconName));

        TextView title = viewHolder.itemView.findViewById(R.id.title);
        title.setText(StringUtils.capitalize(gameInfo.getGameName()));

        TextView description = viewHolder.itemView.findViewById(R.id.description);
        description.setText(StringUtils.capitalize(gameInfo.getGameName() + "sadsafsagfdsa cad wdsac asr qwrw awfd saf"));
    }

    @Override
    public int getItemCount() {
        return gameInfoList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}