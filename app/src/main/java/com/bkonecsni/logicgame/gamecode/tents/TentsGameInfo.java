package com.bkonecsni.logicgame.gamecode.tents;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.tents.validation.TentsValidation;
import com.bkonecsni.logicgame.gamecode.tents.levels.Level1;

public class TentsGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "tents";
        symbolsMap.put("S1", "dot");
        symbolsMap.put("S2", "tree");
        symbolsMap.put("S3", "tent");
        validationHandler = new TentsValidation();
        maps = Arrays.asList(new Level1());
        postProcessGameDefinition();
    }
}
