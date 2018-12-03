package com.bkonecsni.logicgame.gamecode.sentinels.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class SentinelsValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        if (map.twoNeighbouringSymbolsExists(Item.createWithSymbol("S2"), false)) {
            return false;
        }
        map.setConsiderUnMutable(true);
        List<TileBase> tiles = map.getTileList();
        for (TileBase tile : tiles) {
            if (tile.isHelper()) {
                int expectedVisibleTilesNr = tile.getIntValue(1);
                List<TileBase> neighbourTilesForSentinel = map.getTilesInHorizontalAndVerticalLine(tile, true, Item.createWithSymbol("S2"));
                if (neighbourTilesForSentinel.size() != expectedVisibleTilesNr) {
                    return false;
                }
            }
        }
        return true;
    }
}
