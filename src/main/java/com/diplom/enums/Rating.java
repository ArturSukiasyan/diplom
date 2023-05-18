package com.diplom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rating {

    WORST("worst"),
    BAD("bad"),
    NORMAL("normal"),
    GOOD("good"),
    EXCELLENT("excellent");

    private final String rate;
}
