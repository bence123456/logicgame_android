package com.bkonecsni.logicgame.gamecode.binary_sudoku.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class Binary_sudokuValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        map.setConsiderUnMutable(true);
        int rowAndColumnNr = map.getRowNumber();
        int expectedNumber = rowAndColumnNr / 2;
        List<Item> checkedItems = new ArrayList();
        checkedItems.add(Item.createWithIntValue(0));
        checkedItems.add(Item.createWithIntValue(1));
        if (!map.numberOfItemsInAllRowAndColumn(expectedNumber, checkedItems)) {
            return false;
        }
        for (int i = 0; i < rowAndColumnNr; i++) {
            List<TileBase> tilesFromRow = map.getTilesFromRow(i);
            int sameNrSequence = 1;
            int sameNumber = 666;
            for (TileBase rowTile : tilesFromRow) {
                int actualNumber = rowTile.getIntValue(1);
                if (actualNumber != sameNumber) {
                    sameNumber = actualNumber;
                    sameNrSequence = 1;
                } else {
                    sameNrSequence += 1;
                }
                if (sameNrSequence == 3) {
                    return false;
                }
            }
        }
        for (int j = 0; j < rowAndColumnNr; j++) {
            List<TileBase> tilesFromColumn = map.getTilesFromColumn(j);
            int sameNrSequenceCol = 1;
            int sameNumberCol = 666;
            for (TileBase columnTile : tilesFromColumn) {
                int actualNumberCol = columnTile.getIntValue(1);
                if (actualNumberCol != sameNumberCol) {
                    sameNumberCol = actualNumberCol;
                    sameNrSequenceCol = 1;
                } else {
                    sameNrSequenceCol += 1;
                }
                if (sameNrSequenceCol == 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
