package com.bkonecsni.logicgame.gamecode.abc.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class AbcValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        List<TileBase> tiles = map.getTileList();
        for (TileBase tile : tiles) {
            if (tile.isHelper()) {
                Character helperChar = tile.getCharValue(1);
                List<TileBase> playableTiles = map.getPlayableTilesForMarginHelperTile(tile);
                for (int i = 0; i < playableTiles.size(); i++) {
                    TileBase actualTile = playableTiles.get(i);
                    Character firstChar = actualTile.getCharValue(1);
                    if (!map.isNull(firstChar)) {
                        if (firstChar.equals(helperChar)) {
                            break;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        List<Item> checkedItems = new ArrayList();
        checkedItems.add(Item.createWithCharValue('A'));
        checkedItems.add(Item.createWithCharValue('B'));
        checkedItems.add(Item.createWithCharValue('C'));
        return map.numberOfItemsInAllRowAndColumn(1, checkedItems);
    }
}
