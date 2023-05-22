package com.diplom.dto.doctor.request;

import com.diplom.annotation.Unique;
import com.diplom.dto.doctor.DoctorDto;
import com.diplom.dto.subclasses.request.create.CertificateCreateRequestDto;
import com.diplom.dto.subclasses.request.create.EducationCreateRequestDto;
import com.diplom.dto.subclasses.request.create.ExperienceCreateRequestDto;
import com.diplom.service.doctor.DoctorService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorCreateRequestDto extends DoctorDto {

    @NotBlank(message = "mandatory.username")
    @Unique(service = DoctorService.class, fieldName = "username", message = "username.unique.violation")
    private String username;

    @NotBlank(message = "mandatory.password")
    private String password;

    @NotEmpty(message = "doctor.mandatory.educations")
    private List<EducationCreateRequestDto> educations = new ArrayList<>();

    @NotEmpty(message = "doctor.mandatory.experiences")
    private List<ExperienceCreateRequestDto> experiences = new ArrayList<>();

    private List<CertificateCreateRequestDto> certificates = new ArrayList<>();
}
