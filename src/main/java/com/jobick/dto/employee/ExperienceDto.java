package com.jobick.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobick.enums.Availability;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static com.jobick.enums.Constants.DATE_PATTERN;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class ExperienceDto {

    @NotNull(message = "{mandatory.startDate}")
    @JsonFormat(pattern = DATE_PATTERN)
    @Past(message = "{invalid.startDate}")
    private LocalDate startDate;

    @Nullable
    @JsonFormat(pattern = DATE_PATTERN)
    @Past(message = "{invalid.endDate}")
    private LocalDate endDate;

    @Nullable
    @Size(max = 250, message = "{invalid.description}")
    private String description;

    @NotBlank(message = "{mandatory.title}")
    @Size(max = 50, message = "{invalid.title}")
    private String title;

    @NotBlank(message = "{experience.mandatory.companyName}")
    @Size(max = 50, message = "{experience.invalid.companyName}")
    private String companyName;

    @NotNull(message = "{experience.mandatory.availability}")
    private Availability availability;

}
