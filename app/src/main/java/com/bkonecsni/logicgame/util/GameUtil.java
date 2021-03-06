package com.bkonecsni.logicgame.util;

import android.util.Log;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.gamecode.abc.AbcGameInfo;
import com.bkonecsni.logicgame.gamecode.binary_sudoku.Binary_sudokuGameInfo;
import com.bkonecsni.logicgame.gamecode.lighten_up.Lighten_upGameInfo;
import com.bkonecsni.logicgame.gamecode.minesweeper.MinesweeperGameInfo;
import com.bkonecsni.logicgame.gamecode.parks.ParksGameInfo;
import com.bkonecsni.logicgame.gamecode.sentinels.SentinelsGameInfo;
import com.bkonecsni.logicgame.gamecode.skyscrapers.SkyscrapersGameInfo;
import com.bkonecsni.logicgame.gamecode.snake.SnakeGameInfo;
import com.bkonecsni.logicgame.gamecode.sumscrapers.SumscrapersGameInfo;
import com.bkonecsni.logicgame.gamecode.tents.TentsGameInfo;

import java.util.Arrays;
import java.util.List;

public class GameUtil {
    private static final GameUtil ourInstance = new GameUtil();
    private static final String TAG = "GameUtil";
    private static List<AbstractGameInfo> gameInfoList;

    public static GameUtil getInstance() {
        return ourInstance;
    }

    private GameUtil() {
      gameInfoList = Arrays.asList(new ParksGameInfo(), new MinesweeperGameInfo(), new Lighten_upGameInfo(),
              new SumscrapersGameInfo(), new SkyscrapersGameInfo(), new TentsGameInfo(), new SnakeGameInfo(),
              new AbcGameInfo(), new Binary_sudokuGameInfo(), new SentinelsGameInfo());

        for (AbstractGameInfo gameInfo : gameInfoList) {
            gameInfo.init();
        }
    }

    public List<AbstractGameInfo> getGameInfoList() {
        return gameInfoList;
    }


    public static AbstractGameInfo getGameInfo(String gameName) {
        for (AbstractGameInfo gameInfo : gameInfoList) {
            if (gameInfo.getGameName().equals(gameName)) {
                return gameInfo;
            }
        }

        return null;
    }


    public static LevelBase getLevel(String gameName, int levelNumber) {
        AbstractGameInfo gameInfo = getGameInfo(gameName);

        if (gameInfo == null) {
            Log.e(TAG, "GameInfo object for game: "+ gameName + " does not exists!");
        }

        return gameInfo.getMaps().get(levelNumber);
    }

}
