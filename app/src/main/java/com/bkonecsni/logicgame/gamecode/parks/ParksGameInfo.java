package com.bkonecsni.logicgame.gamecode.parks;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import java.util.Arrays;
import com.bkonecsni.logicgame.gamecode.parks.validation.ParksValidation;
import com.bkonecsni.logicgame.gamecode.parks.levels.Level1;
import com.bkonecsni.logicgame.gamecode.parks.levels.Level2;
import com.bkonecsni.logicgame.gamecode.parks.levels.Level3;

public class ParksGameInfo extends AbstractGameInfo {

    public void init() {
        gameName = "parks";
        symbolsMap.put("S1", "src/main/resources/images/symbols/dot.svg");
        symbolsMap.put("S2", "src/main/resources/images/symbols/tree.png");
        validationHandler = new ParksValidation();
        maps = Arrays.asList(new Level1(), new Level2(), new Level3());
        postProcessGameDefinition();
    }
}
