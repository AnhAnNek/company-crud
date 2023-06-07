package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum ELeavStatus {
    APPROVED(1, "Chấp nhận"),
    UNAPPROVED(2, "Chưa giải quyết"),
    DENIED(3, "Từ chối");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    ELeavStatus(Integer value, String desc) {
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
