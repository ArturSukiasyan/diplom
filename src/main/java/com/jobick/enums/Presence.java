package com.jobick.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Presence {
    REMOTE("remote"),
    ON_SITE("onSite"),
    HYBRID("hybrid");

    private final String name;
}
