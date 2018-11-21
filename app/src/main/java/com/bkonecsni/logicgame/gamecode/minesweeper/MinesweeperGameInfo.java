package com.bkonecsni.logicgame.gamecode.minesweeper;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.minesweeper.validation.MinesweeperValidation;
import com.bkonecsni.logicgame.gamecode.minesweeper.levels.Level1;

public class MinesweeperGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "minesweeper";
        symbolsMap.put("S1", "src/main/resources/images/symbols/dot.svg");
        symbolsMap.put("S2", "src/main/resources/images/symbols/bomb.png");
        validationHandler = new MinesweeperValidation();
        maps = Arrays.asList(new Level1());
        postProcessGameDefinition();
    }
}
