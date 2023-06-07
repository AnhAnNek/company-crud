package com.vanannek.companycrud.enums;

import lombok.Data;
import lombok.Getter;

public enum EProjStatus {
    IN_PROCESS(1, "Đang triển khai"),
    COMPLETED(2, "Đã hoàn thành"),
    OVERDUE(3, "Quá hạn"),
    PENDING_PAY(4, "Đang chờ thanh toán"),
    PLANNING(5, "Lên kế hoạch");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    EProjStatus(Integer value, String desc) {
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
