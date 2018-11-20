package com.bkonecsni.logicgame.game.domain.map;

import com.bkonecsni.logicgame.game.domain.common.Item;
import com.bkonecsni.logicgame.game.domain.common.Point;

import java.util.List;

public abstract class CommonComplexTile extends TileBase {

    protected LevelBase map;

    public CommonComplexTile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    @Override
    public boolean isUnmutableType() {
        return false;
    }

    public LevelBase getMap() {
        return map;
    }

    public void setMap(LevelBase map) {
        this.map = map;
    }
}
