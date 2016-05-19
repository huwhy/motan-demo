package com.nachepin.api.dto;

import java.util.HashMap;
import java.util.Map;

import com.nachepin.api.model.enums.IntEnum;

public class EnumUtils {
    private static final Map<Class, Map<String, Enum>> nameEnums = new HashMap<>();
    private static final Map<Class, Map<Integer, Enum>> ordinalEnums = new HashMap<>();

    public EnumUtils() {
    }

    public static <T extends Enum> T getEnum(Class<T> e, EnumValType type, Object val) {
        Enum t;
        if(type == EnumValType.NAME) {
            t = getEnum(e, val.toString());
        } else if(type == EnumValType.MANUAL) {
            t = getEnumByValue(e, val);
        } else {
            t = getEnum(e, Integer.parseInt(val.toString()));
        }

        return (T) t;
    }

    public static <T extends Enum> Object getVal(T t, EnumValType type) {
        Object val;
        if(type == EnumValType.NAME) {
            val = t.name();
        } else if(type == EnumValType.MANUAL) {
            val = ((IntEnum)t).getIntValue();
        } else {
            val = t.ordinal();
        }

        return val;
    }

    private static <T extends Enum> T getEnum(Class<T> clazz, String name) {
        if(!clazz.isEnum()) {
            throw new RuntimeException(clazz.getName() + "is not enum");
        } else {
            Map<String, Enum> enumMap = (Map)nameEnums.get(clazz);
            if(enumMap == null) {
                enumMap = new HashMap<>();
                Enum[] arr$ = clazz.getEnumConstants();
                int len$ = arr$.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    Enum t = arr$[i$];
                    enumMap.put(t.name(), t);
                }

                nameEnums.put(clazz, enumMap);
            }

            return (T) enumMap.get(name);
        }
    }

    private static <T extends Enum> T getEnum(Class<T> clazz, int ordinal) {
        if(!clazz.isEnum()) {
            throw new RuntimeException(clazz.getName() + "is not enum");
        } else {
            Map<Integer, Enum> enumMap = getIntegerEnumMap(clazz);

            return (T) enumMap.get(ordinal);
        }
    }

    private static <T extends Enum> Map<Integer, Enum> getIntegerEnumMap(Class<T> clazz) {
        Map<Integer, Enum> enumMap = ordinalEnums.get(clazz);
        if(enumMap == null) {
            enumMap = new HashMap<>();
            Enum[] ev = clazz.getEnumConstants();
            for(int i = 0; i < ev.length; ++i) {
                Enum t = ev[i];
                enumMap.put(t.ordinal(), t);
            }
            ordinalEnums.put(clazz, enumMap);
        }
        return enumMap;
    }

    private static <T extends Enum> T getEnumByValue(Class<T> clazz, Object value) {
        if(!clazz.isEnum()) {
            throw new RuntimeException(clazz.getName() + "is not enum");
        } else {
            Map<Integer, Enum> enumMap = getIntegerEnumMap(clazz);
            IntEnum e = (IntEnum) enumMap.get(0);
            return (T) e.enumVal(value);
        }
    }
}