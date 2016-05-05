package com.nachepin.api.model.enums;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
public enum UserState {
    normal("在职"),
    leave("离职");

    private UserState(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
