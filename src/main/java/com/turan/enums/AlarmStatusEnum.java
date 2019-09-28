package com.turan.enums;

import lombok.Getter;

@Getter
public enum AlarmStatusEnum
{
    END(0,"结束"),
    START(1,"开始"),
    ;

    private int code;
    private String desc;

    AlarmStatusEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
}
