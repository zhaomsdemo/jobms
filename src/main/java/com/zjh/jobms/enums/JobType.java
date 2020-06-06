package com.zjh.jobms.enums;

public enum JobType {
    CONTRACT(1),
    FULL_TIME(2),
    CONTRACT_TO_HIRE(3);

    private int type;

    JobType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
