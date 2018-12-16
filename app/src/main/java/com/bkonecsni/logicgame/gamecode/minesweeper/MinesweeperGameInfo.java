package com.bkonecsni.logicgame.gamecode.minesweeper;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.minesweeper.validation.MinesweeperValidation;
import com.bkonecsni.logicgame.gamecode.minesweeper.levels.Level1;
import com.bkonecsni.logicgame.gamecode.minesweeper.levels.Level2;
import com.bkonecsni.logicgame.gamecode.minesweeper.levels.Level3;

public class MinesweeperGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "minesweeper";
        symbolsMap.put("S1", "dot");
        symbolsMap.put("S2", "bomb");
        validationHandler = new MinesweeperValidation();
        maps = Arrays.asList(new Level1(), new Level2(), new Level3());
        postProcessGameDefinition();
    }
}
