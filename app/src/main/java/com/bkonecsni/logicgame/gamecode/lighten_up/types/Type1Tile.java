package com.bkonecsni.logicgame.gamecode.lighten_up.types;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.map.CommonComplexTile;
import java.util.ArrayList;
import java.util.List;

public class Type1Tile extends CommonComplexTile {

    public Type1Tile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    public void handleState() {
        Item symbolItem = getItem(1);
        if (map.isNull(symbolItem)) {
            itemList.add(Item.createWithSymbol("S1"));
        } else {
            if (symbolItem.equals(Item.createWithSymbol("S2"))) {
                itemList.remove(symbolItem);
                List<TileBase> horizontalAndVerticalLineTiles = map.getTilesInHorizontalAndVerticalLine(this, true);
                for (TileBase tile : horizontalAndVerticalLineTiles) {
                    Item item = tile.getItem(1);
                    if (tileHasSamePosition(tile) || map.isNull(item) || !item.equals(Item.createWithSymbol("S2"))) {
                        List<TileBase> horizontalAndVerticalLineTilesForTile = map.getTilesInHorizontalAndVerticalLine(tile, false);
                        boolean shouldReplaceColor = true;
                        for (TileBase neighbourTile : horizontalAndVerticalLineTilesForTile) {
                            Item neighbourTileItem = neighbourTile.getItem(1);
                            if (!tileHasSamePosition(neighbourTile) && !map.isNull(neighbourTileItem) && neighbourTileItem.equals(Item.createWithSymbol("S2"))) {
                                shouldReplaceColor = false;
                                break;
                            }
                        }
                        if (shouldReplaceColor) {
                            tile.replaceItem(Item.createWithColor("#000000"), 0);
                        }
                    }
                }
            } else {
                replaceLastItem(Item.createWithSymbol("S2"));
                List<TileBase> tilesInHorizontalAndVerticalLine = map.getTilesInHorizontalAndVerticalLine(this, true);
                for (TileBase tile : tilesInHorizontalAndVerticalLine) {
                    tile.replaceItem(Item.createWithColor("#ffff00"), 0);
                }
            }
        }
    }
}
