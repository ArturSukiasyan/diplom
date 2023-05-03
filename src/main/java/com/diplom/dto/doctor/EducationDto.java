package com.diplom.dto.doctor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static com.diplom.enums.Constants.DATE_PATTERN;

@Getter
@Setter
@NoArgsConstructor
public abstract class EducationDto {

    @NotNull(message = "{mandatory.startDate}")
    @JsonFormat(pattern = DATE_PATTERN)
    @Past(message = "{invalid.startDate}")
    private LocalDate startDate;

    @JsonFormat(pattern = DATE_PATTERN)
    @Past(message = "{invalid.endDate}")
    private LocalDate endDate;

    @Size(max = 50, message = "{education.invalid.place}")
    @NotBlank(message = "{education.mandatory.place}")
    private String place;

    @Nullable
    @Size(max = 250, message = "{invalid.description}")
    private String description;

    @Nullable
    @Size(max = 50, message = "{education.invalid.faculty}")
    private String faculty;

}
