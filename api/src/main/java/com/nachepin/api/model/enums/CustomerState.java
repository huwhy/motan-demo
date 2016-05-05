package com.nachepin.api.model.enums;

/**
 * @auther huwhy
 * @date 2016/4/28.
 */
public enum CustomerState {
    normal("正常", 0),
    stop("停用", 1);

    private String name;
    private int value;

    private CustomerState(String name, int value){
        this.name = name;
        this.value = value;
    }
}
