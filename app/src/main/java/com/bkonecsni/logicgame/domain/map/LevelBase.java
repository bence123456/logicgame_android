package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.HelperTileLocation;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;

import java.util.*;
import java.util.List;

public abstract class LevelBase {

    protected List<TileBase> tileList;

    protected boolean considerUnMutable = false;

    public abstract void init();

    public boolean isNull(Object object) {
        return object == null;
    }

    public void setItemListForTile(Point position, List<Item> itemList) {
        TileBase tile = getTile(position.x, position.y);
        if (tile != null) {
            tile.setItemList(itemList);
        }
    }

    public TileBase getTile(int row, int column) {
        for (TileBase tile : tileList) {
            if (getRowNumber(tile) == row && getColumnNumber(tile) == column) {
                return tile;
            }
        }

        return null;
    }

    public Item getItem(TileBase tileBase, int i) {
        return tileBase.getItemList().get(i);
    }

    public TileBase getTile(int i) {
        return tileList.get(i);
    }

    public int getRowNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        return tmpTiles.get(0).getPosition().x + 1;
    }

    public int getColumnNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        return tmpTiles.get(0).getPosition().y + 1;
    }

    public int getPlayableRowNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        removeTilesWithBorderType(tmpTiles);

        return tmpTiles.get(0).getPosition().x + 1;
    }

    public int getPlayableColumnNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        removeTilesWithBorderType(tmpTiles);

        return tmpTiles.get(0).getPosition().y + 1;
    }

    public int getFirstPlayableColumnIndex() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        removeTilesWithBorderType(tmpTiles);

        TileBase lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().y;
    }

    public int getFirstPlayableRowIndex() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        removeTilesWithBorderType(tmpTiles);

        TileBase lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().x;
    }

    public int getLastPlayableColumnIndex() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        Collections.reverse(tmpTiles);
        removeTilesWithBorderType(tmpTiles);

        TileBase lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().y;
    }

    public int getLastPlayableRowIndex() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        Collections.reverse(tmpTiles);
        removeTilesWithBorderType(tmpTiles);

        TileBase lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().x;
    }

    public List<TileBase> getPlayableTilesForMarginHelperTile(TileBase tileBase) {
        List<TileBase> playableTilesInRowOrColumn = new ArrayList<>();
        int columnNumber = getColumnNumber(tileBase);
        int rowNumber = getRowNumber(tileBase);

        switch (getHelperTileLocation(tileBase)) {
            case TOP:
                playableTilesInRowOrColumn.addAll(getTilesFromColumn(columnNumber));
                break;
            case BOTTOM:
                List<TileBase> tilesFromColumn = getTilesFromColumn(columnNumber);
                Collections.reverse(tilesFromColumn);
                playableTilesInRowOrColumn.addAll(tilesFromColumn);
                break;
            case LEFT:
                playableTilesInRowOrColumn.addAll(getTilesFromRow(rowNumber));
                break;
            case RIGHT:
                List<TileBase> tilesFromRow = getTilesFromRow(rowNumber);
                Collections.reverse(tilesFromRow);
                playableTilesInRowOrColumn.addAll(tilesFromRow);
                break;
            case NONE:
                break;
        }

        return playableTilesInRowOrColumn;
    }

    public List<TileBase> getTilesFromRow(int rowNumber) {
        List<TileBase> tilesInRow = new ArrayList<>();

        for (TileBase tile : tileList) {
            if (getRowNumber(tile) == rowNumber && !tile.isUnmutableType()) {
                tilesInRow.add(tile);
            }
        }

        return tilesInRow;
    }

    public List<TileBase> getTilesFromColumn(int columnNumber) {
        List<TileBase> tilesInColumn = new ArrayList<>();

        for (TileBase tile : tileList) {
            if (getColumnNumber(tile) == columnNumber && !tile.isUnmutableType()) {
                tilesInColumn.add(tile);
            }
        }

        return tilesInColumn;
    }

    public List<String> getDistinctPlayableTileColorList() {
        List<String> colors = new ArrayList<>();

        for (TileBase tile : tileList) {
            String tileColor = tile.getItemList().get(0).getColor();
            if (!colors.contains(tileColor) && !tile.isUnmutableType()) {
                colors.add(tileColor);
            }
        }

        return colors;
    }

    public List<TileBase> getTilesForColor(String color) {
        List<TileBase> tiles = new ArrayList<>();

        for (TileBase tile : tileList) {
            String tileColor = tile.getItemList().get(0).getColor();
            if (tileColor.equals(color) && !tile.isUnmutableType()) {
                tiles.add(tile);
            }
        }

        return tiles;
    }

    public List<TileBase> getNeighboursForTile(TileBase tile) {
        List<TileBase> tiles = new ArrayList<>();

        addNeighboursToListIfExists(tile, tiles);

        return tiles;
    }

    public boolean hasHorizontalOrVerticalNeighbourWithItem(TileBase tile, Item item) {
        List<TileBase> horizontalVerticalNeighbourTiles = getHorizontalAndVerticalNeighboursForTile(tile);

        for (TileBase horizontalVerticalNeighbourTile : horizontalVerticalNeighbourTiles) {
            Item neighbourItem = horizontalVerticalNeighbourTile.getItem(1);
            if (neighbourItem != null && neighbourItem.equals(item)) {
                return true;
            }
        }

        return false;
    }

    public List<TileBase> getHorizontalAndVerticalNeighboursForTile(TileBase tile) {
        List<TileBase> tiles = new ArrayList<>();
        int rowNr = getRowNumber(tile);
        int columnNr = getColumnNumber(tile);

        addHorizontalAndVerticalNeighbours(tiles, rowNr, columnNr);

        return tiles;
    }

    public List<TileBase> getTilesInHorizontalAndVerticalLine(TileBase tile, boolean shouldIncludeItself) {
        List<TileBase> tiles = new ArrayList<>();
        if (shouldIncludeItself) {
            tiles.add(tile);
        }

        int rowNr = getRowNumber(tile);
        int columnNr = getColumnNumber(tile);
        int lastPlayableRowIndex = getLastPlayableRowIndex();
        int lastPlayableColumnIndex = getLastPlayableColumnIndex();

        addTilesInHorizontalOrVerticalLine(tiles, columnNr+1, lastPlayableColumnIndex, 1, true, rowNr);
        addTilesInHorizontalOrVerticalLine(tiles, columnNr-1, 0, -1, true, rowNr);
        addTilesInHorizontalOrVerticalLine(tiles, rowNr+1, lastPlayableRowIndex, 1, false, columnNr);
        addTilesInHorizontalOrVerticalLine(tiles, rowNr-1, 0, -1, false, columnNr);

        return tiles;
    }

    public void addTilesInHorizontalOrVerticalLine(List<TileBase> tiles, int startIndex, int endIndex, int increment,
                                                   boolean isHorizontal, int rowOrColumnIndex) {

        for (int i=startIndex; endIndex == 0 ? i>=endIndex : i<=endIndex; i=i+increment) {
            TileBase tile = isHorizontal ? getTile(rowOrColumnIndex, i) : getTile(i, rowOrColumnIndex);

            if (!tile.isUnmutableType()) {
                tiles.add(tile);
            } else {
                break;
            }
        }
    }

    public List<TileBase> getTilesWithGivenItem(List<TileBase> tileList, Item item) {
        List<TileBase> tilesWithGivenItem = new ArrayList<>();

        for (TileBase tile : tileList) {
            if (tile.getItemList().contains(item) && (considerUnMutable || !tile.isUnmutableType())) {
                tilesWithGivenItem.add(tile);
            }
        }

        return tilesWithGivenItem;
    }

    public List<TileBase> getTilesWithGivenItem(Item item) {
        return getTilesWithGivenItem(tileList, item);
    }

    public boolean numberOfItemsInAllRow(Item item, int expectedNumber) {
        int numberOfRows = getRowNumber();
        int numberOfPlayableRows = getPlayableRowNumber();
        int firstPlayableRowIndex = getFirstPlayableRowIndex();
        int lastIndex = numberOfRows == numberOfPlayableRows ? numberOfRows : numberOfPlayableRows;

        for (int j=firstPlayableRowIndex; j<lastIndex; j++) {
            if (!isAreaValid(getTilesFromRow(j), item, expectedNumber)) {
                return false;
            }
        }

        return true;
    }

    public boolean numberOfItemsInAllColumn(Item item, int expectedNumber) {
        int numberOfColumns = getColumnNumber();
        int numberOfPlayableColumns = getPlayableColumnNumber();
        int firstPlayableColumnIndex = getFirstPlayableColumnIndex();
        int lastIndex = numberOfColumns == numberOfPlayableColumns ? numberOfColumns : numberOfPlayableColumns;

        for (int j=firstPlayableColumnIndex; j<lastIndex; j++) {
            if (!isAreaValid(getTilesFromColumn(j), item, expectedNumber)) {
                return false;
            }
        }

        return true;
    }

    public boolean numberOfItemsInAllAreaWithSameColor(Item item, int expectedNumber) {
        Map<String, List<TileBase>> colorAreaTilesMap = createColorAreaTilesMap();

        for (String color : colorAreaTilesMap.keySet()) {
            if (!isAreaValid(colorAreaTilesMap.get(color), item, expectedNumber)) {
                return false;
            }
        }

        return true;
    }

    public boolean twoNeighbouringSymbolsExists(Item symbolItem) {
        List<TileBase> tilesWithGivenItem = getTilesWithGivenItem(symbolItem);

        for (TileBase tile : tilesWithGivenItem) {
            List<TileBase> neighbourTiles =  getNeighboursForTile(tile);
            for (TileBase neighbourTile : neighbourTiles) {
                if (neighbourTile.getItemList().contains(symbolItem)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean neighboursHaveCorrectNumberOfItems(Item item) {
        for (TileBase tile : tileList) {
            if (tile.isUnmutableType()) {
                int expectedNrOfItems = tile.getItemList().get(1).getIntValue();
                int actualNrOfItems = 0;

                for (TileBase unMutableTileNeighbour : getNeighboursForTile(tile)) {
                    if (unMutableTileNeighbour.getItemList().contains(item)) {
                        actualNrOfItems++;
                    }
                }

                if (expectedNrOfItems != actualNrOfItems) {
                    return false;
                }
            }
        }

        return true;
    }

    private void addDiagonaNeighbours(List<TileBase> tiles, int rowNr, int columnNr) {
        addNeighbourToListIfExists(rowNr-1, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr-1, columnNr+1, tiles);

        addNeighbourToListIfExists(rowNr+1, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr+1, columnNr+1, tiles);
    }

    private boolean isAreaValid(List<TileBase> tiles, Item item, int expectedNumber) {
        int numberOfItems = 0;

        for (TileBase tile : tiles) {
            if (tile.getItemList().contains(item)) {
                numberOfItems++;
            }
        }

        return numberOfItems == expectedNumber;
    }

    private Map<String, List<TileBase>> createColorAreaTilesMap() {
        Map<String, List<TileBase>> colorAreaTilesMap = new HashMap<>();
        List<String> colorList = getDistinctPlayableTileColorList();

        for (String color : colorList) {
            List<TileBase> tilesForcolor = getTilesForColor(color);
            colorAreaTilesMap.put(color, tilesForcolor);
        }

        return colorAreaTilesMap;
    }

    private void removeTilesWithBorderType(List<TileBase> tmpTiles) {
        tmpTiles.removeIf(actualTile -> actualTile.isUnmutableType());
    }

    private void addNeighboursToListIfExists(TileBase tile, List<TileBase> tiles) {
        int rowNr = getRowNumber(tile);
        int columnNr = getColumnNumber(tile);

        addHorizontalAndVerticalNeighbours(tiles, rowNr, columnNr);
        addDiagonaNeighbours(tiles, rowNr, columnNr);
    }

    private void addHorizontalAndVerticalNeighbours(List<TileBase> tiles, int rowNr, int columnNr) {
        addNeighbourToListIfExists(rowNr, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr, columnNr+1, tiles);

        addNeighbourToListIfExists(rowNr-1, columnNr, tiles);
        addNeighbourToListIfExists(rowNr+1, columnNr, tiles);
    }

    private void addNeighbourToListIfExists(int row, int column, List<TileBase> tiles) {
        TileBase tile = getTile(row, column);

        if (tile != null && (considerUnMutable || !tile.isUnmutableType())) {
            tiles.add(tile);
        }
    }

    private List<TileBase> getSortedTilesBasedOnRow() {
        List<TileBase> tmpTiles = new ArrayList<>();
        tmpTiles.addAll(tileList);
        tmpTiles.sort(TileBase.getRowNrComparator());

        return tmpTiles;
    }

    private List<TileBase> getSortedTilesBasedOnColumn() {
        List<TileBase> tmpTiles = new ArrayList<>();
        tmpTiles.addAll(tileList);
        tmpTiles.sort(TileBase.getColumnNrComparator());

        return tmpTiles;
    }

    private HelperTileLocation getHelperTileLocation(TileBase tile) {
        int x = getRowNumber(tile);
        int y = getColumnNumber(tile);
        int lastPlayableRowNr = getLastPlayableRowIndex();
        int lastPlayableColumnNr = getLastPlayableColumnIndex();

        if (x==0 && y>0 && y<=lastPlayableColumnNr) {
            return HelperTileLocation.TOP;
        } else if (x==lastPlayableRowNr+1 && y>0 && y<=lastPlayableColumnNr) {
            return HelperTileLocation.BOTTOM;
        } else if (y==0 && x>0 && x<=lastPlayableRowNr) {
            return HelperTileLocation.LEFT;
        } else if (y==lastPlayableColumnNr+1 && x>0 && x<=lastPlayableRowNr) {
            return HelperTileLocation.RIGHT;
        }

        return HelperTileLocation.NONE;
    }

    private int getRowNumber(TileBase tile) {
        return tile.getPosition().x;
    }

    private int getColumnNumber(TileBase tile) {
        return tile.getPosition().y;
    }

    public List<TileBase> getTileList() {
        return tileList;
    }

    public void setConsiderUnMutable(boolean considerUnMutable) {
        this.considerUnMutable = considerUnMutable;
    }
}
