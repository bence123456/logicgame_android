package com.bkonecsni.logicgame.domain.types.equation;

import com.bkonecsni.logicgame.domain.common.Item;

public class Equation {

    private Integer leftItemIndex;

    private Item rightItem;

    public Equation(Integer leftItemIndex, Item rightItem) {
        this.leftItemIndex = leftItemIndex;
        this.rightItem = rightItem;
    }

    public Integer getLeftItemIndex() {
        return leftItemIndex;
    }

    public void setLeftItemIndex(Integer leftItemIndex) {
        this.leftItemIndex = leftItemIndex;
    }

    public Item getRightItem() {
        return rightItem;
    }

    public void setRightItem(Item rightItem) {
        this.rightItem = rightItem;
    }
}
