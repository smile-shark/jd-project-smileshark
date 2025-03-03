package com.jd.utils;

import java.util.Arrays;

public class SearchUtils {
    public static String toBroadString(String searchContent) {
        if (searchContent == null || searchContent.isEmpty()) {
            return "";
        }
        return "%" + String.join("%", searchContent.split("")) + "%";
    }
}
