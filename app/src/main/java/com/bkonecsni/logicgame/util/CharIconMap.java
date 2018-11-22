package com.bkonecsni.logicgame.util;

import logicgame.bkonecsni.com.logicgame.R;

public enum CharIconMap {

    A(R.drawable.a),
    B(R.drawable.b),
    C(R.drawable.c),
    D(R.drawable.d),
    E(R.drawable.e);

    private int icon;

    CharIconMap(int icon) {
        this.icon = icon;
    }

    public static int getDrawableIcon(Character charValue) {
        for (CharIconMap charIconMap : CharIconMap.values()) {
            if (charIconMap.name().equals(charValue)) {
                return charIconMap.icon;
            }
        }

        return 666;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
