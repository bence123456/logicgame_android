package com.bkonecsni.logicgame.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkonecsni.logicgame.activities.LevelsActivity;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.util.IconProvider;
import com.bkonecsni.logicgame.util.StringService;

import java.util.List;

import logicgame.bkonecsni.com.logicgame.R;

import static com.bkonecsni.logicgame.activities.LevelsActivity.GAME_NAME;
import static com.bkonecsni.logicgame.util.IconProvider.DEFAULT_PACKAGE;

public class GamesAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<AbstractGameInfo> gameInfoList;

    private Context context;

    public GamesAdapter(List<AbstractGameInfo> gameInfoList) {
        this.gameInfoList = gameInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();

        return new GamesViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.game_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String gameName = gameInfoList.get(i).getGameName();

        addOnClickListener(viewHolder, gameName);

        setGameIcon(viewHolder, gameName);
        setTitle(viewHolder, gameName);
        setDescription(viewHolder, gameName);
    }

    private void addOnClickListener(@NonNull RecyclerView.ViewHolder viewHolder, String gameName) {
        viewHolder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, LevelsActivity.class);
            intent.putExtra(GAME_NAME, gameName);
            context.startActivity(intent);
        });
    }

    private void setGameIcon(@NonNull RecyclerView.ViewHolder viewHolder, String gameName) {
        ImageView gameIcon = viewHolder.itemView.findViewById(R.id.gameIcon);
        String iconName = gameName + "_icon";
        int icon = IconProvider.getDrawable(context, iconName);
        gameIcon.setImageIcon(Icon.createWithResource(context, icon));
    }

    private void setTitle(@NonNull RecyclerView.ViewHolder viewHolder, String gameName) {
        TextView title = viewHolder.itemView.findViewById(R.id.title);
        title.setText(StringService.getFormattedTitle(gameName));
    }

    private void setDescription(@NonNull RecyclerView.ViewHolder viewHolder, String gameName) {
        TextView description = viewHolder.itemView.findViewById(R.id.description);

        int resId = context.getResources().getIdentifier(gameName+"_description", "string", DEFAULT_PACKAGE);
        description.setText(context.getString(resId));
    }

    @Override
    public int getItemCount() {
        return gameInfoList.size();
    }

    protected static class GamesViewHolder extends ViewHolder {
        public GamesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
