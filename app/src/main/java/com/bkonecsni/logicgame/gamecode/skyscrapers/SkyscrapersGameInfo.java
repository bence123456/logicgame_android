package com.bkonecsni.logicgame.gamecode.skyscrapers;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.skyscrapers.validation.SkyscrapersValidation;
import com.bkonecsni.logicgame.gamecode.skyscrapers.levels.Level1;
import com.bkonecsni.logicgame.gamecode.skyscrapers.levels.Level2;
import com.bkonecsni.logicgame.gamecode.skyscrapers.levels.Level3;

public class SkyscrapersGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "skyscrapers";
        validationHandler = new SkyscrapersValidation();
        maps = Arrays.asList(new Level1(), new Level2(), new Level3());
        postProcessGameDefinition();
    }
}
