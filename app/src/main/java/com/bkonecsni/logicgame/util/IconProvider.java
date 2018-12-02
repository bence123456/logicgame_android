package com.bkonecsni.logicgame.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;

import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.common.Item;

import java.util.Map;

public class IconProvider {

    public static final String DEFAULT_PACKAGE = "logicgame.bkonecsni.com.logicgame";

    public static Icon getIconForMap(Item item, AbstractGameInfo gameInfo, Context context){
        Icon icon = null;

        if (item.getCharValue() != null) {
            int drawable = getDrawable(context, String.valueOf(item.getCharValue()).toLowerCase());
            icon = Icon.createWithResource(context, drawable);
        } else if (item.getIntValue() != null) {
            int drawable = NumberIconMap.getDrawableIcon(item.getIntValue());
            icon = Icon.createWithResource(context, drawable);
        } else {
            int drawable = getDrawable(item.getSymbol(), gameInfo, context);
            icon = Icon.createWithResource(context, drawable);
        }

        return icon;
    }

    private static int getDrawable(String inputSymbol, AbstractGameInfo gameInfo, Context context) {
        Map<String, String> symbolsMap = gameInfo.getSymbolsMap();

        for (String symbol : symbolsMap.keySet()) {
            if (symbol.equals(inputSymbol)) {
                String iconName = symbolsMap.get(symbol);

                return getDrawable(context, iconName);
            }
        }

        return 666;
    }

    public static int getDrawable(Context context, String pictureName) {
        Resources resources = context.getResources();
        return resources.getIdentifier(pictureName, "drawable", DEFAULT_PACKAGE);
    }
}
