package com.diplom.dto.doctor.request.update;

import com.diplom.dto.doctor.EducationRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class EducationUpdateRequestDto extends EducationRequestDto {

    @NotBlank(message = "{mandatory.id}")
    private Long id;
}
