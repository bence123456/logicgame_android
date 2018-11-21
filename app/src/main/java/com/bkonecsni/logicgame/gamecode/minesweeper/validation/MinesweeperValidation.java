package com.bkonecsni.logicgame.gamecode.minesweeper.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperValidation extends ValidationBase {

    public boolean areWinConditionsApply() {
        return map.neighboursHaveCorrectNumberOfItems(Item.createWithSymbol("S2"));
    }
}
