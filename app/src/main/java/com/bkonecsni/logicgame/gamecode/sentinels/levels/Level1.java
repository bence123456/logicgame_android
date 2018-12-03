package com.bkonecsni.logicgame.gamecode.sentinels.levels;

import com.bkonecsni.logicgame.gamecode.sentinels.types.Type0Tile;
import com.bkonecsni.logicgame.gamecode.sentinels.types.Type1Tile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level1 extends LevelBase {

    public void init() {
        this.tileList = Arrays.asList(new Type1Tile(new Point(0, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(0, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(0, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(0, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(4)))), new Type1Tile(new Point(1, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(1, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(1, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(1, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(5)))), new Type0Tile(new Point(2, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(7)))), new Type1Tile(new Point(2, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(2, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(2, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(5)))), new Type1Tile(new Point(3, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(3, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type1Tile(new Point(3, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))));
    }
}
