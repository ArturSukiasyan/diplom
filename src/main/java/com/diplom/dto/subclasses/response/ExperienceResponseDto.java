package com.diplom.dto.subclasses.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ExperienceResponseDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String title;
    private String companyName;
    private String companyAddress;
}
