package com.jobick.dto.employee.response;

import com.jobick.dto.employee.ExperienceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ExperienceResponseDto extends ExperienceDto {

    @NotNull
    private Long id;

}
