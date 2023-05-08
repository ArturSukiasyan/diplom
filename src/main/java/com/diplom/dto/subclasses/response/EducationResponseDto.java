package com.diplom.dto.subclasses.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EducationResponseDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String place;
    private String description;
    private String faculty;
}
