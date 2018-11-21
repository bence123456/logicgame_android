package com.bkonecsni.logicgame.gamecode.parks.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class ParksValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        return map.numberOfItemsInAllRow(Item.createWithSymbol("S2"), 1) && map.numberOfItemsInAllColumn(Item.createWithSymbol("S2"), 1) && map.numberOfItemsInAllAreaWithSameColor(Item.createWithSymbol("S2"), 1) && !map.twoNeighbouringSymbolsExists(Item.createWithSymbol("S2"));
    }
}
