package com.bkonecsni.logicgame.gamecode.skyscrapers.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class SkyscrapersValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        List<TileBase> tiles = map.getTileList();
        for (TileBase tile : tiles) {
            if (tile.isHelper()) {
                int skylineNumber = tile.getIntValue(1);
                int visibleSkylineNumber = 1;
                List<TileBase> playableTiles = map.getPlayableTilesForMarginHelperTile(tile);
                TileBase actualTile = playableTiles.get(0);
                for (int i = 1; i < playableTiles.size(); i++) {
                    TileBase nextTile = playableTiles.get(i);
                    int nextTileIntValue = nextTile.getIntValue(1);
                    if (actualTile.getIntValue(1) < nextTileIntValue) {
                        visibleSkylineNumber += 1;
                        actualTile = nextTile;
                    }
                }
                if (skylineNumber != visibleSkylineNumber) {
                    return false;
                }
            }
        }
        boolean valid = map.numberOfItemsInAllRow(Item.createWithIntValue(1), 1) && map.numberOfItemsInAllRow(Item.createWithIntValue(2), 1) && map.numberOfItemsInAllRow(Item.createWithIntValue(3), 1) && map.numberOfItemsInAllRow(Item.createWithIntValue(4), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(1), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(2), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(3), 1) && map.numberOfItemsInAllColumn(Item.createWithIntValue(4), 1);
        return valid;
    }
}
