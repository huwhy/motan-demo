package com.nachepin.api.model.enums;

public enum GoodsType {
    cushion("汽车坐垫"),
    floorMat("汽车脚垫"),
    wheelCover("方向盘套"),
    carTrim("汽车内饰"),
    other("其他");

    private String name;

    private GoodsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static GoodsType valOf(String val) {
        GoodsType e = other;
        for (GoodsType type : GoodsType.values()) {
            if (type.name().equals(val)) {
                e = type;
                break;
            }
        }
        return e;
    }
}
