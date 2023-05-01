package com.jobick.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Availability {
    FULL_TIME("fullTime"),
    PART_TIME("partTime"),
    CONTRACT("contract"),
    INTERNSHIP("internship"),
    OTHER("other");

    private final String type;

}
