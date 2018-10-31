package com.imooc.song.common;

public class StringUtils {

    private StringUtils(){

    }

    public static boolean isNotEmptyString(String string) {
        return !"".equals(string) && null != string;
    }
}
