package com.bkonecsni.logicgame.gamecode.sentinels;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.sentinels.validation.SentinelsValidation;
import com.bkonecsni.logicgame.gamecode.sentinels.levels.Level1;

public class SentinelsGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "sentinels";
        symbolsMap.put("S1", "dot");
        symbolsMap.put("S2", "tower");
        validationHandler = new SentinelsValidation();
        maps = Arrays.asList(new Level1());
        postProcessGameDefinition();
    }
}
