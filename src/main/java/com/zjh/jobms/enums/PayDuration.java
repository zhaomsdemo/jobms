package com.zjh.jobms.enums;

public enum PayDuration {

    SEMI_MONTHLY(1),
    BI_WEEKLY(2),
    MONTHLY(3),
    WEEKLY(4),
    ;

    private int value;

    PayDuration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
