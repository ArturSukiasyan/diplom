package com.diplom.dto.doctor.response;

import com.diplom.dto.doctor.ExperienceDto;
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
