package com.bkonecsni.logicgame.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;

import com.bkonecsni.logicgame.MainActivity;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.common.Item;

import java.util.Map;

public class IconProvider {

    public static Icon getIcon(Item item, AbstractGameInfo gameInfo){
        Icon icon = null;
        Context appContext = MainActivity.getAppContext();

        if (item.getCharValue() != null) {
            int drawable = CharIconMap.getDrawableIcon(item.getCharValue());
//            int drawable = getDrawable(String.valueOf(item.getCharValue()).toLowerCase());
            icon = Icon.createWithResource(appContext, drawable);
        } else if (item.getIntValue() != null) {
            int drawable = NumberIconMap.getDrawableIcon(item.getIntValue());
            icon = Icon.createWithResource(appContext, drawable);
        } else {
            int drawable = getDrawable(item.getSymbol(), gameInfo);
            icon = Icon.createWithResource(appContext, drawable);
        }

        return icon;
    }

    private static int getDrawable(String inputSymbol, AbstractGameInfo gameInfo) {
        Map<String, String> symbolsMap = gameInfo.getSymbolsMap();

        for (String symbol : symbolsMap.keySet()) {
            if (symbol.equals(inputSymbol)) {
                String iconName = symbolsMap.get(symbol);

                return getDrawable(iconName);
            }
        }

        return 666;
    }

    private static int getDrawable(String pictureName) {
        Resources resources = MainActivity.getAppContext().getResources();
        return resources.getIdentifier(pictureName, "drawable", "logicgame.bkonecsni.com.logicgame");
    }
}
