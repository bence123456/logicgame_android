package com.bkonecsni.logicgame.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.util.IconProvider;

import java.util.ArrayList;
import java.util.List;

public class MapAdapter extends BaseAdapter {

    private List<TileBase> tileList = new ArrayList<>();
    private AbstractGameInfo gameInfo;

    public MapAdapter(List<TileBase> tiles, AbstractGameInfo gameInfo) {
        tileList.addAll(tiles);
        this.gameInfo = gameInfo;
    }

    public int getCount() {
        return tileList.size();
    }

    public Object getItem(int position) {
        return tileList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = setupImageView(convertView, parent);

        handleChange(position, imageView, parent.getContext());

        return imageView;
    }

    private MapTileItemImageView setupImageView(View convertView, ViewGroup parent) {
        MapTileItemImageView imageView;

        if (convertView == null) {
            imageView = new MapTileItemImageView(parent.getContext());
            int padding = 32;
            imageView.setPadding(padding, padding, padding, padding);
        } else {
            imageView = (MapTileItemImageView) convertView;
        }

        return imageView;
    }

    private void handleChange(int position, ImageView imageView, Context context) {
        TileBase tile = tileList.get(position);
        imageView.setBackgroundColor(Color.parseColor(tile.getColor(0)));

        Item item = tile.getItem(1);
        if (item != null) {
            Icon icon = IconProvider.getIconForMap(item, gameInfo, context);
            imageView.setImageIcon(icon);
        } else {
            imageView.setImageIcon(null);
        }
    }

    public void setTileList(List<TileBase> tileList) {
        this.tileList = tileList;
    }

    class MapTileItemImageView extends AppCompatImageView {

        public MapTileItemImageView(Context context) {
            super(context);
        }

        public MapTileItemImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MapTileItemImageView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        }
    }
}
