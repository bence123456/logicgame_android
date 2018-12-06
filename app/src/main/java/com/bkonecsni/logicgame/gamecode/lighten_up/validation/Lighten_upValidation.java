package com.bkonecsni.logicgame.gamecode.lighten_up.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class Lighten_upValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        List<TileBase> tiles = map.getTileList();
        for (TileBase tile : tiles) {
            if (tile.isHelper()) {
                int expectedAdjacentBulbsNr = tile.getIntValue(1);
                List<TileBase> neighbourTiles = map.getHorizontalAndVerticalNeighboursForTile(tile);
                int actualAdjacentBulbsNr = 0;
                for (int i = 0; i < neighbourTiles.size(); i++) {
                    TileBase actualTile = neighbourTiles.get(i);
                    List<Item> itemList = actualTile.getItemList();
                    if (itemList.contains(Item.createWithSymbol("S2"))) {
                        actualAdjacentBulbsNr += 1;
                    }
                }
                if (expectedAdjacentBulbsNr != actualAdjacentBulbsNr) {
                    return false;
                }
            } else {
                Item colorItem = tile.getItem(0);
                if (!tile.isUnmutableType() && !map.isNull(colorItem) && !colorItem.equals(Item.createWithColor("#ffff00"))) {
                    return false;
                }
            }
        }
        List<TileBase> tilesWithBulbs = map.getTilesWithGivenItem(Item.createWithSymbol("S2"));
        for (TileBase bulbTile : tilesWithBulbs) {
            List<TileBase> neighbourTilesForBulbTile = map.getTilesInHorizontalAndVerticalLine(bulbTile, false);
            for (TileBase neighbourTile : neighbourTilesForBulbTile) {
                List<Item> neighbourItemList = neighbourTile.getItemList();
                if (neighbourItemList.contains(Item.createWithSymbol("S2"))) {
                    return false;
                }
            }
        }
        return true;
    }
}
