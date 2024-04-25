package ru.rest.L5.enums;

import lombok.Getter;

public enum AccStatus {

    CLOSE ("CLOSE"),
    OPEN ("OPEN"),
    RESERV ("RESERV"),
    DELETED("DELETED");


    @Getter
    private String desc;

    AccStatus(String desc) {
        this.desc = desc;
    }
}
