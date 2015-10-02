package com.zakioussama.treemerger;

/**
 *
 * @author Oussama Zaki
 */
public class Util {
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBlank(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static String concatPath(String s1, String s2, char separator) {
        return s1 + separator + s2;
    }
}
