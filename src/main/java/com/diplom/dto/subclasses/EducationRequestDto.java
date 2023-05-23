package com.diplom.dto.subclasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public abstract class EducationRequestDto {

    @NotNull(message = "mandatory.startDate")
    @Past(message = "invalid.startDate")
    private LocalDate startDate;

    @Past(message = "invalid.endDate")
    private LocalDate endDate;

    @Size(max = 50, message = "education.invalid.place")
    @NotBlank(message = "education.mandatory.place")
    private String place;

    @Nullable
    @Size(max = 250, message = "invalid.description")
    private String description;

    @Nullable
    @Size(max = 50, message = "education.invalid.faculty")
    private String faculty;
}
