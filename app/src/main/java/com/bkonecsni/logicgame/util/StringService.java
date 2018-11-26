package com.bkonecsni.logicgame.util;

import org.apache.commons.lang3.StringUtils;

public class StringService {

    public static String getFormattedTitle(String title) {
        String capitalizedTitle = StringUtils.capitalize(title);
        String formattedTitle = StringUtils.replaceAll(capitalizedTitle, "_", " ");

        return formattedTitle;
    }
}
