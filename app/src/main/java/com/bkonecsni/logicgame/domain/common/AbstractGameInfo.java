package com.bkonecsni.logicgame.domain.common;

import com.bkonecsni.logicgame.domain.map.CommonComplexTile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;

import java.util.*;

public abstract class AbstractGameInfo {

    protected String gameName;

    protected Map<String, String> symbolsMap = new HashMap<>();

    protected List<LevelBase> maps = new ArrayList<>();

    protected ValidationBase validationHandler;

    public abstract void init();

    protected void postProcessGameDefinition() {
        for (LevelBase map : maps) {
            map.init();

            for (TileBase tile : map.getTileList()) {
                if (tile instanceof CommonComplexTile) {
                    ((CommonComplexTile) tile).setMap(map);
                }
            }
        }
    }

    public int getNumberOfMaps() {
        return maps.size();
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Map<String, String> getSymbolsMap() {
        return symbolsMap;
    }

    public void setSymbolsMap(Map<String, String> symbolsMap) {
        this.symbolsMap = symbolsMap;
    }

    public List<LevelBase> getMaps() {
        return maps;
    }

    public void setMaps(List<LevelBase> maps) {
        this.maps = maps;
    }

    public ValidationBase getValidationHandler() {
        return validationHandler;
    }

    public void setValidationHandler(ValidationBase validationHandler) {
        this.validationHandler = validationHandler;
    }
}
