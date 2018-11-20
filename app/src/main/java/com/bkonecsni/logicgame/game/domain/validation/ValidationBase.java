package com.bkonecsni.logicgame.game.domain.validation;

import com.bkonecsni.logicgame.game.domain.map.LevelBase;

public abstract class ValidationBase {

    protected LevelBase map;

    public abstract boolean areWinConditionsApply();

    public LevelBase getMap() {
        return map;
    }

    public void setMap(LevelBase map) {
        this.map = map;
    }
}
