package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum ETaskStatus {
    IN_PROCESS(1, "Đang thực hiện"),
    COMPLETED(2, "Đã hoàn thành"),
    OVERDUE(3, "Quá hạn"),
    REVIEWING(4, "Đang xem xét"),
    CANCELLED(5, "Hủy");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    ETaskStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}

