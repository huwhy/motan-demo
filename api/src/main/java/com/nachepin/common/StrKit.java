package com.nachepin.common;

public class StrKit {

    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if(firstChar >= 65 && firstChar <= 90) {
            char[] arr = str.toCharArray();
            arr[0] = (char)(arr[0] + 32);
            return new String(arr);
        } else {
            return str;
        }
    }

    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if(firstChar >= 97 && firstChar <= 122) {
            char[] arr = str.toCharArray();
            arr[0] = (char)(arr[0] - 32);
            return new String(arr);
        } else {
            return str;
        }
    }

    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isBlanks(String... strings) {
        if(strings == null) {
            return true;
        } else {
            String[] arr$ = strings;
            int len$ = strings.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                if(str == null || "".equals(str.trim())) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean notBlank(String str) {
        return str != null && !"".equals(str.trim());
    }

    public static boolean notBlank(String... strings) {
        if(strings == null) {
            return false;
        } else {
            String[] arr$ = strings;
            int len$ = strings.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                if(str == null || "".equals(str.trim())) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean notNull(Object... paras) {
        if(paras == null) {
            return false;
        } else {
            Object[] arr$ = paras;
            int len$ = paras.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Object obj = arr$[i$];
                if(obj == null) {
                    return false;
                }
            }

            return true;
        }
    }
}
