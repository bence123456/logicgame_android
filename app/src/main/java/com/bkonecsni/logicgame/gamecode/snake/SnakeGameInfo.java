package com.bkonecsni.logicgame.gamecode.snake;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.snake.validation.SnakeValidation;
import com.bkonecsni.logicgame.gamecode.snake.levels.Level1;
import com.bkonecsni.logicgame.gamecode.snake.levels.Level2;
import com.bkonecsni.logicgame.gamecode.snake.levels.Level3;

public class SnakeGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "snake";
        symbolsMap.put("S1", "dot");
        validationHandler = new SnakeValidation();
        maps = Arrays.asList(new Level1(), new Level2(), new Level3());
        postProcessGameDefinition();
    }
}
