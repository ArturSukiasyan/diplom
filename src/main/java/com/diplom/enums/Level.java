package com.diplom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Level {
    INTERN("intern"),
    JUNIOR("junior"),
    MIDDLE("middle"),
    SENIOR("senior"),
    DIRECTOR("director"),
    EXPERT("expert"),
    OTHER("other");

    private final String name;

}
