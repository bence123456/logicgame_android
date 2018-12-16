package com.bkonecsni.logicgame.gamecode.sumscrapers.levels;

import com.bkonecsni.logicgame.gamecode.sumscrapers.types.Type2Tile;
import com.bkonecsni.logicgame.gamecode.sumscrapers.types.Type0Tile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level1 extends LevelBase {

    public void init() {
        this.tileList = Arrays.asList(new Type0Tile(new Point(0, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF")))), new Type0Tile(new Point(0, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(7)))), new Type0Tile(new Point(0, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(5)))), new Type0Tile(new Point(0, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(4)))), new Type0Tile(new Point(0, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(9)))), new Type0Tile(new Point(0, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF")))), new Type0Tile(new Point(1, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(7)))), new Type2Tile(new Point(1, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(1, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(6)))), new Type0Tile(new Point(2, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(5)))), new Type2Tile(new Point(2, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(2, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(7)))), new Type0Tile(new Point(3, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(4)))), new Type2Tile(new Point(3, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(3, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(3, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(3, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(8)))), new Type0Tile(new Point(4, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(9)))), new Type2Tile(new Point(4, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(4, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(4)))), new Type0Tile(new Point(5, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF")))), new Type0Tile(new Point(5, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(6)))), new Type0Tile(new Point(5, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(7)))), new Type0Tile(new Point(5, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(8)))), new Type0Tile(new Point(5, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF"), Item.createWithIntValue(4)))), new Type0Tile(new Point(5, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#FFFFFF")))));
    }
}
