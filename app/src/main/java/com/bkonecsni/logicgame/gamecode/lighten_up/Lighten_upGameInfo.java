package com.bkonecsni.logicgame.gamecode.lighten_up;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.lighten_up.validation.Lighten_upValidation;
import com.bkonecsni.logicgame.gamecode.lighten_up.levels.Level1;

public class Lighten_upGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "lighten_up";
        symbolsMap.put("S1", "dot");
        symbolsMap.put("S2", "lightbulb");
        validationHandler = new Lighten_upValidation();
        maps = Arrays.asList(new Level1());
        postProcessGameDefinition();
    }
}
