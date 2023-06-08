package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum EPermission {
    MGR(1, "Manager"),
    DEP_HEAD(2, "Department Head"),
    NOR_EMPL(3, "Normal Employee"),
    HR(4, "Human Resource"),
    NOT_ALLOW(5, "Not allow");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    EPermission(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static EProjStatus fromValue(Integer value) {
        for (EProjStatus status : EProjStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid EProjStatus value: " + value);
    }
}
