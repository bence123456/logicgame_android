package com.bkonecsni.logicgame.gamecode.sumscrapers;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.sumscrapers.validation.SumscrapersValidation;
import com.bkonecsni.logicgame.gamecode.sumscrapers.levels.Level1;
import com.bkonecsni.logicgame.gamecode.sumscrapers.levels.Level2;
import com.bkonecsni.logicgame.gamecode.sumscrapers.levels.Level3;

public class SumscrapersGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "sumscrapers";
        validationHandler = new SumscrapersValidation();
        maps = Arrays.asList(new Level1(), new Level2(), new Level3());
        postProcessGameDefinition();
    }
}
