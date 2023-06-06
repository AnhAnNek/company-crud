package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum EProjStatus {
    InProcess(1, "Đang triển khai"),
    Completed(2, "Đã hoàn thành"),
    Overdue(3, "Quá hạn"),
    PendingPay(4, "Đang chờ thanh toán"),
    Planning(5, "Lên kế hoạch");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    EProjStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
