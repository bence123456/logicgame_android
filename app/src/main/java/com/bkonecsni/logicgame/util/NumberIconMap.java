package com.bkonecsni.logicgame.util;

import logicgame.bkonecsni.com.logicgame.R;

public enum NumberIconMap {

    ZERO(0, R.drawable.zero),
    ONE(1, R.drawable.one),
    TWO(2, R.drawable.two),
    THREE(3, R.drawable.three),
    FOUR(4, R.drawable.four),
    FIVE(5, R.drawable.five),
    SIX(6, R.drawable.six),
    SEVEN(7, R.drawable.seven),
    EIGHT(8, R.drawable.eight),
    NINE(9, R.drawable.nine);

    private int intValue;
    private int icon;

    NumberIconMap(int intValue, int icon) {
        this.intValue = intValue;
        this.icon = icon;
    }

    public static int getDrawableIcon(int intValue) {
        for (NumberIconMap numberIconMap : NumberIconMap.values()) {
            if (numberIconMap.intValue == intValue) {
                return numberIconMap.icon;
            }
        }

        return 666;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


}
