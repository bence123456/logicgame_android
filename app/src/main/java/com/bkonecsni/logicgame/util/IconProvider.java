package com.bkonecsni.logicgame.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;

import com.bkonecsni.logicgame.activities.MapActivity;
import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;
import com.bkonecsni.logicgame.domain.common.Item;

import java.util.Map;

public class IconProvider {

    public static final String DEFAULT_PACKAGE = "logicgame.bkonecsni.com.logicgame";

    public static Icon getIconForMap(Item item, AbstractGameInfo gameInfo){
        Icon icon = null;
        Context appContext = MapActivity.getAppContext();

        if (item.getCharValue() != null) {
            int drawable = CharIconMap.getDrawableIcon(item.getCharValue());
//            int drawable = getDrawable(String.valueOf(item.getCharValue()).toLowerCase());
            icon = Icon.createWithResource(appContext, drawable);
        } else if (item.getIntValue() != null) {
            int drawable = NumberIconMap.getDrawableIcon(item.getIntValue());
            icon = Icon.createWithResource(appContext, drawable);
        } else {
            int drawable = getDrawable(item.getSymbol(), gameInfo, appContext);
            icon = Icon.createWithResource(appContext, drawable);
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
