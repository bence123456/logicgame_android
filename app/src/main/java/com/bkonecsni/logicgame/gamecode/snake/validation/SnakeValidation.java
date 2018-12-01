package com.bkonecsni.logicgame.gamecode.snake.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class SnakeValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        List<TileBase> tiles = map.getTileList();
        int lastSnakePartPos = map.getPlayableRowNumber() - 1;
        TileBase firstSnakeTile = map.getTile(0, 0);
        TileBase lastSnakeTile = map.getTile(lastSnakePartPos, lastSnakePartPos);
        Item firstSnakeItem = firstSnakeTile.getItem(0);
        Item lastSnakeItem = lastSnakeTile.getItem(0);
        if (!firstSnakeItem.equals(Item.createWithColor("#FFFFFF")) || !lastSnakeItem.equals(Item.createWithColor("#FFFFFF"))) {
            return false;
        }
        return map.rightAndBottomHelperTilesAreValid(Item.createWithColor("#FFFFFF"));
    }
}
