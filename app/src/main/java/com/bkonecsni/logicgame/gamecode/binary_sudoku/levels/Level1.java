package com.bkonecsni.logicgame.gamecode.binary_sudoku.levels;

import com.bkonecsni.logicgame.gamecode.binary_sudoku.types.Type2Tile;
import com.bkonecsni.logicgame.gamecode.binary_sudoku.types.Type0Tile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level1 extends LevelBase {

    public void init() {
        this.tileList = Arrays.asList(new Type2Tile(new Point(0, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(0, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(0, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(0, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(0, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(0, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(0, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(0, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(1, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(1, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type0Tile(new Point(1, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(2, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(2, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(2, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(2, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(2, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type0Tile(new Point(3, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(3, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(3, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(3, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(3, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(3, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(4, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(4, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(4, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(4, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(5, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(6, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(6, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(0)))), new Type2Tile(new Point(6, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(6, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(6, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(6, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(6, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(6, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(7, 0), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(7, 1), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(7, 2), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))), new Type2Tile(new Point(7, 3), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(7, 4), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(7, 5), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type2Tile(new Point(7, 6), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080")))), new Type0Tile(new Point(7, 7), new Point(40, 40), new ArrayList(Arrays.asList(Item.createWithColor("#808080"), Item.createWithIntValue(1)))));
    }
}
