package com.bkonecsni.logicgame.domain.common;

import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;

import java.util.*;

public class GameDefinition {

    private String gameName;

    private Map<String, String> symbolsMap = new HashMap<>();

    private Set<String> definedTypes = new HashSet<>();

    private Map<String, LevelBase> maps = new HashMap<>();

    private Map<Integer, String> numberIconMap = new HashMap<>();

    private ValidationBase validationHandler;

    public GameDefinition(String gameName) {
        this.gameName = gameName;
    }

    public String getIcon(Item item) {
        if (item == null) {
            return null;
        }

        Integer intValue = item.getIntValue();

        if (intValue != null) {
            return this.getNumberIconMap().get(intValue);
        } else {
            return this.getSymbolsMap().get(item.getSymbol());
        }
    }

    public String getGameName() {
        return gameName;
    }

    public Map<String, String> getSymbolsMap() {
        return symbolsMap;
    }

    public Set<String> getDefinedTypes() {
        return definedTypes;
    }

    public Map<String, LevelBase> getMaps() {
        return maps;
    }

    public Map<Integer, String> getNumberIconMap() {
        return numberIconMap;
    }

    public ValidationBase getValidationHandler() {
        return validationHandler;
    }

    public void setValidationHandler(ValidationBase validationHandler) {
        this.validationHandler = validationHandler;
    }
}
