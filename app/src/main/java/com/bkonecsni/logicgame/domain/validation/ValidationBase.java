package com.bkonecsni.logicgame.domain.validation;

import com.bkonecsni.logicgame.domain.map.LevelBase;

public abstract class ValidationBase {

    public abstract boolean areWinConditionsApply(LevelBase map);
}
