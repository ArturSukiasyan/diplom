package com.jobick.dto.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public abstract class LanguageDto {

    @NotBlank(message = "{language.mandatory.lang}")
    @Size(max = 20, message = "{language.invalid.lang}")
    private String lang;

    @NotNull(message = "{language.mandatory.level}")
    @Min(value = 1, message = "{language.invalid.level}")
    @Max(value = 10, message = "{language.invalid.level}")
    private Integer level;

}
