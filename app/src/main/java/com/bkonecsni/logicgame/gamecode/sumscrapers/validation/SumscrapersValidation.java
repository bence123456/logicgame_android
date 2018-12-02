package com.bkonecsni.logicgame.gamecode.sumscrapers.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class SumscrapersValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        List<TileBase> tiles = map.getTileList();
        for (TileBase tile : tiles) {
            if (tile.isHelper()) {
                int skylineNumber = tile.getIntValue(1);
                List<TileBase> playableTiles = map.getPlayableTilesForMarginHelperTile(tile);
                TileBase actualTile = playableTiles.get(0);
                int sumOfVisibleSkylineNumbers = actualTile.getIntValue(1);
                for (int i = 1; i < playableTiles.size(); i++) {
                    TileBase nextTile = playableTiles.get(i);
                    int nextTileIntValue = nextTile.getIntValue(1);
                    if (actualTile.getIntValue(1) < nextTileIntValue) {
                        sumOfVisibleSkylineNumbers += nextTileIntValue;
                        actualTile = nextTile;
                    }
                }
                if (skylineNumber != sumOfVisibleSkylineNumbers) {
                    return false;
                }
            }
        }
        List<Item> checkedItems = new ArrayList();
        checkedItems.add(Item.createWithIntValue(1));
        checkedItems.add(Item.createWithIntValue(2));
        checkedItems.add(Item.createWithIntValue(3));
        checkedItems.add(Item.createWithIntValue(4));
        return map.numberOfItemsInAllRowAndColumn(1, checkedItems);
    }
}
