package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;

import java.util.Comparator;
import java.util.List;

public abstract class TileBase {

    protected Point position;

    protected Point size;

    protected List<Item> itemList;

    public TileBase(Point position, Point size, List<Item> itemList) {
        this.position = position;
        this.size = size;
        this.itemList = itemList;
    }

    public abstract void handleState();

    public abstract boolean isUnmutableType();

    public boolean isHelper() {
        return isUnmutableType() && itemList.size() > 1;
    }

    public void replaceLastItem(Item newItem) {
        int itemsSize = itemList.size();
        replaceItem(newItem, itemsSize-1);
    }

    public void replaceItem(Item newItem, int itemIndex) {
        if (itemIndex < itemList.size() && newItem != null && !newItem.equals(itemList.get(itemIndex))) {
            itemList.set(itemIndex, newItem);
        }
    }

    public boolean tileHasSamePosition(TileBase otherTile) {
        int otherPositionX = otherTile.getPosition().x;
        int otherPositionY = otherTile.getPosition().y;

        return position.x == otherPositionX && position.y == otherPositionY;
    }

    public Character getCharValue(int itemIndex) {
        Item item = getItem(itemIndex);
        return item == null ? null : item.getCharValue();
    }

    public Integer getIntValue(int itemIndex) {
        Item item = getItem(itemIndex);
        return item == null ? -1 : item.getIntValue();
    }

    public String getSymbol(int itemIndex) {
        Item item = getItem(itemIndex);
        return item == null ? null : item.getSymbol();
    }

    public String getColor(int itemIndex) {
        Item item = getItem(itemIndex);
        return item == null ? null : item.getColor();
    }

    public static Comparator<TileBase> getColumnNrComparator() {
        return (tile1, tile2) -> {
            int tile1Column = tile1.getPosition().y;
            int tile2Column = tile2.getPosition().y;

            return tile2Column - tile1Column;
        };
    }

    public static Comparator<TileBase> getRowNrComparator() {
        return (tile1, tile2) -> {
            int tile1Row = tile1.getPosition().x;
            int tile2Row = tile2.getPosition().x;

            return tile2Row - tile1Row;
        };
    }

    public Item getItem(int itemIndex) {
        return itemList.size() <= itemIndex ? null : itemList.get(itemIndex);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
