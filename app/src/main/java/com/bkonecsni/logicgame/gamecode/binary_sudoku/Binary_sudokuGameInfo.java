package com.bkonecsni.logicgame.gamecode.binary_sudoku;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.binary_sudoku.validation.Binary_sudokuValidation;
import com.bkonecsni.logicgame.gamecode.binary_sudoku.levels.Level1;

public class Binary_sudokuGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "binary_sudoku";
        validationHandler = new Binary_sudokuValidation();
        maps = Arrays.asList(new Level1());
        postProcessGameDefinition();
    }
}
