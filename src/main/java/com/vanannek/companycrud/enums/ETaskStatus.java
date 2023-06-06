package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum ETaskStatus {
    InProcess(1, "Đang thực hiện"),
    Completed(2, "Đã hoàn thành"),
    Overdue(3, "Quá hạn"),
    Reviewing(4, "Đang xem xét"),
    Cancelled(5, "Hủy");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    ETaskStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}

