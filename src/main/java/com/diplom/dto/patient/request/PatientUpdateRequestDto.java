package com.diplom.dto.patient.request;

import com.diplom.dto.patient.PatientDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PatientUpdateRequestDto extends PatientDto {

    @NotBlank(message = "mandatory.id")
    private Long id;

}
