package com.diplom.dto.doctor.request;

import com.diplom.dto.doctor.DoctorDto;
import com.diplom.dto.subclasses.request.update.CertificateUpdateRequestDto;
import com.diplom.dto.subclasses.request.update.EducationUpdateRequestDto;
import com.diplom.dto.subclasses.request.update.ExperienceUpdateRequestDto;
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
public class DoctorUpdateRequestDto extends DoctorDto {

    @NotBlank(message = "{mandatory.id}")
    private Long id;

    @NotEmpty(message = "{doctor.mandatory.educations}")
    private List<EducationUpdateRequestDto> educations = new ArrayList<>();

    @NotEmpty(message = "{doctor.mandatory.experiences}")
    private List<ExperienceUpdateRequestDto> experiences = new ArrayList<>();

    private List<CertificateUpdateRequestDto> certificates = new ArrayList<>();
}
