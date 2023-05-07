package com.diplom.dto.doctor.request.update;

import com.diplom.dto.doctor.ExperienceRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ExperienceUpdateRequestDto extends ExperienceRequestDto {

    @NotBlank(message = "{mandatory.id}")
    private Long id;
}
