package com.bkonecsni.logicgame;

import android.graphics.Color;
import android.graphics.drawable.Icon;
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

    List<TileBase> tileList = new ArrayList<>();
    private AbstractGameInfo gameInfo;

    public MapAdapter(List<TileBase> tiles, AbstractGameInfo gameInfo) {
        tileList.addAll(tiles);
        this.gameInfo = gameInfo;
    }

    public int getCount() {
        return tileList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        TileBase tile = tileList.get(position);
        imageView.setBackgroundColor(Color.parseColor(tile.getColor(0)));

        Item item = tile.getItem(1);
        if (item != null) {
            Icon icon = IconProvider.getIcon(item, gameInfo);
            imageView.setImageIcon(icon);
        } else {
            imageView.setImageIcon(null);
        }

        return imageView;
    }

}
