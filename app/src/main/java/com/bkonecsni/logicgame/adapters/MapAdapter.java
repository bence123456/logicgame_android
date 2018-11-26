package com.bkonecsni.logicgame.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
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

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = setupImageView(convertView, parent);

        handleChange(position, imageView);

        return imageView;
    }

    @NonNull
    private ImageView setupImageView(View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(parent.getContext());
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        return imageView;
    }

    private void handleChange(int position, ImageView imageView) {
        TileBase tile = tileList.get(position);
        imageView.setBackgroundColor(Color.parseColor(tile.getColor(0)));

        Item item = tile.getItem(1);
        if (item != null) {
            Icon icon = IconProvider.getIconForMap(item, gameInfo);
            imageView.setImageIcon(icon);
        } else {
            imageView.setImageIcon(null);
        }
    }

    public void setTileList(List<TileBase> tileList) {
        this.tileList = tileList;
    }

    class MapTileItem extends android.support.v7.widget.AppCompatImageView {
        public MapTileItem(Context context) {
            super(context);
        }

        public MapTileItem(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MapTileItem(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        }
    }
}
