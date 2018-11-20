package com.bkonecsni.logicgame.game.domain.types.equation;

import com.bkonecsni.logicgame.game.domain.common.Item;

import java.util.List;

public class Update extends Equation{

    public Update(Integer itemToUpdateIndex, Item newItem) {
        super(itemToUpdateIndex, newItem);
    }

    public void execute(List<Item> itemList) {
        Integer itemToUpdateIndex = getLeftItemIndex();
        Item newItem = getRightItem();

        if (itemToUpdateIndex == itemList.size()) {
            itemList.add(newItem);
        } else {
            if (newItem != null) {
                itemList.set(itemToUpdateIndex, newItem);
            } else {
                Item oldItem = itemList.get(itemToUpdateIndex);
                itemList.remove(oldItem); // ItemList(x) = empty
            }
        }
    }
}
