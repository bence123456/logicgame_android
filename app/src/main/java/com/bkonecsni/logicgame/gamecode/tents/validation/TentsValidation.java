package com.bkonecsni.logicgame.gamecode.tents.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import java.util.ArrayList;
import java.util.List;

public class TentsValidation extends ValidationBase {

    public boolean areWinConditionsApply(LevelBase map) {
        map.setConsiderUnMutable(true);
        if (map.twoNeighbouringSymbolsExists(Item.createWithSymbol("S3"))) {
            return false;
        } else {
            List<TileBase> treeTiles = map.getTilesWithGivenItem(Item.createWithSymbol("S2"));
            List<TileBase> tentTiles = map.getTilesWithGivenItem(Item.createWithSymbol("S3"));
            if (treeTiles.size() != tentTiles.size()) {
                return false;
            }
            for (TileBase treeTile : treeTiles) {
                if (!map.hasHorizontalOrVerticalNeighbourWithItem(treeTile, Item.createWithSymbol("S3"))) {
                    return false;
                }
            }
            for (TileBase tentTile : tentTiles) {
                if (!map.hasHorizontalOrVerticalNeighbourWithItem(tentTile, Item.createWithSymbol("S2"))) {
                    return false;
                }
            }
            int rowNr = map.getRowNumber() - 1;
            int columnNr = map.getColumnNumber() - 1;
            for (int i = 0; i < rowNr; i++) {
                TileBase tileInRow = map.getTile(i, columnNr);
                int expectedTentsInRow = tileInRow.getIntValue(1);
                List<TileBase> tilesFromRow = map.getTilesFromRow(i);
                List<TileBase> tentTilesFromRow = map.getTilesWithGivenItem(tilesFromRow, Item.createWithSymbol("S3"));
                if (tentTilesFromRow.size() != expectedTentsInRow) {
                    return false;
                }
            }
            for (int j = 0; j < columnNr; j++) {
                TileBase tileInColumn = map.getTile(rowNr, j);
                int expectedTentsInColumn = tileInColumn.getIntValue(1);
                List<TileBase> tilesFromColumn = map.getTilesFromColumn(j);
                List<TileBase> tentTilesFromColumn = map.getTilesWithGivenItem(tilesFromColumn, Item.createWithSymbol("S3"));
                if (tentTilesFromColumn.size() != expectedTentsInColumn) {
                    return false;
                }
            }
        }
        return true;
    }
}
