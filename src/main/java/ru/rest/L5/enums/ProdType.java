package ru.rest.L5.enums;

import lombok.Getter;

@Getter
public enum ProdType {

    //НСО, СМО, ЕЖО, ДБДС, договор

    NSO("НСО"),
    CMO("СМО"),
    EGO("ЕЖО"),
    DBDS("ДБДС"),
    DGV("договор");

    private String desc;

    ProdType(String desc) {
        this.desc = desc;
    }
}
