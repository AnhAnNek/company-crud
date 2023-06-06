package com.vanannek.companycrud.enums;

import lombok.Getter;

public enum EPermission {
    Mgr(1, "Manager"),
    DepHead(2, "Department Head"),
    NorEmpl(3, "Normal Employee"),
    HR(4, "Human Resource"),
    NotAllow(5, "Not allow");

    @Getter
    private final Integer value;
    @Getter
    private final String desc;

    EPermission(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
