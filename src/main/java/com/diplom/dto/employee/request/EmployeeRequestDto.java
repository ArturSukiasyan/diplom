package com.diplom.dto.employee.request;

import com.diplom.dto.employee.EmployeeDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public abstract class EmployeeRequestDto extends EmployeeDto {

    private List<@Valid LanguageRequestDto> languages = new ArrayList<>();

    private List<@Valid EducationRequestDto> educations = new ArrayList<>();

    private List<@Valid ExperienceRequestDto> experiences = new ArrayList<>();

    private List<@Valid CertificateRequestDto> certificates = new ArrayList<>();

}
