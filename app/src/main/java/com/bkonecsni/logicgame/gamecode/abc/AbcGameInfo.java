package com.bkonecsni.logicgame.gamecode.abc;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.abc.validation.AbcValidation;
import com.bkonecsni.logicgame.gamecode.abc.levels.Level1;
import com.bkonecsni.logicgame.gamecode.abc.levels.Level2;
import com.bkonecsni.logicgame.gamecode.abc.levels.Level3;

public class AbcGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "abc";
        validationHandler = new AbcValidation();
        maps = Arrays.asList(new Level1(), new Level2(), new Level3());
        postProcessGameDefinition();
    }
}
