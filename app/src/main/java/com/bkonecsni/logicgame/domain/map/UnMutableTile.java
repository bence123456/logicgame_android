package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;

import java.util.List;

public class UnMutableTile extends TileBase {

    public UnMutableTile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    @Override
    public void handleState() {}

    @Override
    public boolean isUnmutableType() {
        return true;
    }
}
