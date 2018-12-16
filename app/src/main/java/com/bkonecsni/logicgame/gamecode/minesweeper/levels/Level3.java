package com.bkonecsni.logicgame.gamecode.minesweeper.levels;

import com.bkonecsni.logicgame.gamecode.minesweeper.types.Type2Tile;
import com.bkonecsni.logicgame.gamecode.minesweeper.types.Type0Tile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level3 extends LevelBase {

    public void init() {
        this.tileList = Arrays.asList(new Type0Tile(new Point(0, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type0Tile(new Point(0, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(2)))), new Type2Tile(new Point(0, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(0, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(2)))), new Type2Tile(new Point(0, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(1, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(3)))), new Type0Tile(new Point(1, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(2)))), new Type2Tile(new Point(2, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(2, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(3)))), new Type0Tile(new Point(2, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(2)))), new Type2Tile(new Point(2, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(4)))), new Type2Tile(new Point(3, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(2)))), new Type2Tile(new Point(3, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(4, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(4, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(2)))), new Type0Tile(new Point(4, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(4, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))));
    }
}