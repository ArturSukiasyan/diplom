package com.diplom.dto.patient.request;

import com.diplom.annotation.Unique;
import com.diplom.dto.patient.PatientDto;
import com.diplom.service.PatientService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PatientCreateRequestDto extends PatientDto {

    @NotBlank(message = "mandatory.username")
    @Unique(service = PatientService.class, fieldName = "username", message = "username.unique.violation")
    private String username;

    @NotBlank(message = "mandatory.password")
    private String password;
}
