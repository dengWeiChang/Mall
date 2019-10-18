package com.dedu.mall.enums;

/**
 * 专栏类型
 */
public enum SpecialType {

    /**
     * 电脑专栏
     */
    COMPUTER(1),
    /**
     * 吃货专栏
     */
    EAT(2);

    private int type;
    SpecialType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
