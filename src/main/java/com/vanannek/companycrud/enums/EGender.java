package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum EGender {
    MALE(1, "Nam"),
    FEMALE(2, "Nữ"),
    OTHER(3, "Khác");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    EGender(Integer value, String desc) {
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
