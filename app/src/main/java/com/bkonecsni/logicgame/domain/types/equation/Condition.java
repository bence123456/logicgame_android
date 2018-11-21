package com.bkonecsni.logicgame.domain.types.equation;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class Condition extends Equation {

    public Condition(Integer comparableItemIndex, Item itemToCompare) {
        super(comparableItemIndex, itemToCompare);
    }

    public boolean isConditionMatch(List<Item> itemList) {
        Integer comparableItemIndex = getLeftItemIndex();
        Item itemToCompare = getRightItem();

        if (itemList.size() - 1 < comparableItemIndex) {
            // handle ItemList(x) == empty case
            return itemToCompare == null;
        }
        Item comparableItem = itemList.get(comparableItemIndex);

        return comparableItem.equals(itemToCompare);
    }

}
