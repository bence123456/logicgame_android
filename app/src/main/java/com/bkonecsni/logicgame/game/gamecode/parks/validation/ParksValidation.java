package com.bkonecsni.logicgame.game.gamecode.parks.validation;

import com.bkonecsni.logicgame.game.domain.common.Item;
import com.bkonecsni.logicgame.game.domain.map.TileBase;
import com.bkonecsni.logicgame.game.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class ParksValidation extends ValidationBase {

    public boolean areWinConditionsApply() {
        return map.numberOfItemsInAllRow(Item.createWithSymbol("S2"), 1) && map.numberOfItemsInAllColumn(Item.createWithSymbol("S2"), 1) && map.numberOfItemsInAllAreaWithSameColor(Item.createWithSymbol("S2"), 1) && !map.twoNeighbouringSymbolsExists(Item.createWithSymbol("S2"));
    }
}
