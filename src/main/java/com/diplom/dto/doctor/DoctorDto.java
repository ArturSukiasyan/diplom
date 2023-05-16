package com.diplom.dto.doctor;

import com.diplom.annotation.PhoneNumber;
import com.diplom.annotation.Unique;
import com.diplom.dto.subclasses.CertificateRequestDto;
import com.diplom.dto.subclasses.EducationRequestDto;
import com.diplom.dto.subclasses.ExperienceRequestDto;
import com.diplom.service.doctor.DoctorService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class DoctorDto {

    @Email
    @NotBlank(message = "{mandatory.email}")
    @Unique(service = DoctorService.class, fieldName = "email", message = "{email.unique.violation}")
    private String email;

    @PhoneNumber
    @NotBlank(message = "{mandatory.phone}")
    @Unique(service = DoctorService.class, fieldName = "phoneNumber", message = "{phone.unique.violation}")
    private String phoneNumber;

    @NotBlank(message = "{mandatory.firstName}")
    private String firstName;

    @NotBlank(message = "{mandatory.lastName}")
    private String lastName;

    @Size(max = 250, message = "{invalid.description}")
    private String description;

    @NotBlank(message = "{doctor.mandatory.specialty}")
    private String specialty;

    @NotNull(message = "{doctor.mandatory.yearsOfExperience}")
    private Integer yearsOfExperience;
}