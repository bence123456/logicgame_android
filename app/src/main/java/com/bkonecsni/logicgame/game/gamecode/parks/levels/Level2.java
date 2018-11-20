package com.bkonecsni.logicgame.game.gamecode.parks.levels;

import gamecode.parks.types.Type2Tile;
import com.bkonecsni.logicgame.game.domain.map.LevelBase;
import com.bkonecsni.logicgame.game.domain.common.Item;
import com.bkonecsni.logicgame.game.domain.common.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level2 extends LevelBase {

    public void init() {
        this.tileList = Arrays.asList(new Type2Tile(new Point(0, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(0, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(0, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(0, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(0, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(1, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#080")))), new Type2Tile(new Point(1, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(1, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(1, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(1, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#080")))), new Type2Tile(new Point(2, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#080")))), new Type2Tile(new Point(2, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#080")))), new Type2Tile(new Point(2, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#C08")))), new Type2Tile(new Point(2, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(3, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(3, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#AC0")))), new Type2Tile(new Point(3, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#C08")))), new Type2Tile(new Point(3, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#C08")))), new Type2Tile(new Point(3, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#008")))), new Type2Tile(new Point(4, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#AC0")))), new Type2Tile(new Point(4, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#C08")))), new Type2Tile(new Point(4, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#C08")))), new Type2Tile(new Point(4, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#C08")))));
    }
}
