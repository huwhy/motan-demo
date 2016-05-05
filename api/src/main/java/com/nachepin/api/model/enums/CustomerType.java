package com.nachepin.api.model.enums;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
public enum CustomerType {
    normal("普通", 0),
    buyer("进货商", 1),
    seller("供货商", 2);

    private String name;
    private int value;

    private CustomerType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Object getVal() {
        return value;
    }

    public String getName() {
        return name;
    }
}
