package com.ccortez.desafioinfoglobo.common;

public class StringUtil {

    public static String removeLastChar(String str, String lastChar) {
        if (str != null && str.length() > 0
                && str.charAt(str.length() - 1) == lastChar.charAt(0)) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

}
