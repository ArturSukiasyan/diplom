package com.diplom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String type;

}
