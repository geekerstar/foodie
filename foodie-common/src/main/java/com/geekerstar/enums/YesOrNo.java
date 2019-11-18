package com.geekerstar.enums;

/**
 * @author geekerstar
 * date: 2019/11/17 14:45
 * description: 性别枚举
 */
public enum YesOrNo {
    NO(0,"否"),
    YES(1,"是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
