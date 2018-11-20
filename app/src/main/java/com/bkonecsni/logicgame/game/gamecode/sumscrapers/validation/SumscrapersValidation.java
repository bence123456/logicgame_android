package com.bkonecsni.logicgame.game.gamecode.sumscrapers.validation;

import com.bkonecsni.logicgame.game.domain.common.Item;
import com.bkonecsni.logicgame.game.domain.map.TileBase;
import com.bkonecsni.logicgame.game.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class SumscrapersValidation extends ValidationBase {

    public boolean areWinConditionsApply() {
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
        boolean valid = map.numberOfItemsInAllRow(Item.createWithIntValue(1), 1) && map.numberOfItemsInAllRow(Item.createWithIntValue(2), 1) && map.numberOfItemsInAllRow(Item.createWithIntValue(3), 1) && map.numberOfItemsInAllRow(Item.createWithIntValue(4), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(1), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(2), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(3), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(4), 1);
        return valid;
    }
}
