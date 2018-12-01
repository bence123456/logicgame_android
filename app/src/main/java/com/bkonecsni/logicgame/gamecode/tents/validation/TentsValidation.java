package com.bkonecsni.logicgame.gamecode.tents.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class TentsValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        map.setConsiderUnMutable(true);
        if (map.twoNeighbouringSymbolsExists(Item.createWithSymbol("S3"))) {
            return false;
        }
        List<TileBase> treeTiles = map.getTilesWithGivenItem(Item.createWithSymbol("S2"));
        List<TileBase> tentTiles = map.getTilesWithGivenItem(Item.createWithSymbol("S3"));
        if (treeTiles.size() != tentTiles.size()) {
            return false;
        }
        for (TileBase treeTile : treeTiles) {
            if (!map.hasHorizontalOrVerticalNeighbourWithItem(treeTile, Item.createWithSymbol("S3"))) {
                return false;
            }
        }
        for (TileBase tentTile : tentTiles) {
            if (!map.hasHorizontalOrVerticalNeighbourWithItem(tentTile, Item.createWithSymbol("S2"))) {
                return false;
            }
        }
        return map.rightAndBottomHelperTilesAreValid(Item.createWithSymbol("S3"));
    }
}
