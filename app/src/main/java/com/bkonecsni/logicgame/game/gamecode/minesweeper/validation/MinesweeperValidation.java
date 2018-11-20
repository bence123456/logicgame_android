package com.bkonecsni.logicgame.game.gamecode.minesweeper.validation;

import com.bkonecsni.logicgame.game.domain.common.Item;
import com.bkonecsni.logicgame.game.domain.map.TileBase;
import com.bkonecsni.logicgame.game.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperValidation extends ValidationBase {

    public boolean areWinConditionsApply() {
        return map.neighboursHaveCorrectNumberOfItems(Item.createWithSymbol("S2"));
    }
}
