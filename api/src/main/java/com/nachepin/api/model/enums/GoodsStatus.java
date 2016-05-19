package com.nachepin.api.model.enums;


public enum GoodsStatus implements IntEnum {
    wait_audit("待审核", 0),
    back_audit("退回", 5),
    online("上架", 10),
    offline("下架", 20),
    deleted("已删除", 30);

    private String name;
    private int value;

    private GoodsStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer getIntValue() {
        return value;
    }

    @Override
    public Enum enumVal(Object value) {
        int val = (int) value;
        GoodsStatus e = null;
        switch (val) {
            case 0:
                e = wait_audit;
                break;
            case 5:
                e = back_audit;
                break;
            case 10:
                e = online;
                break;
            case 20:
                e = offline;
                break;
            case 30:
                e = deleted;
                break;

        }
        return e;
    }

}
