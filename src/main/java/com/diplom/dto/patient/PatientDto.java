package com.diplom.dto.patient;

import com.diplom.annotation.PhoneNumber;
import com.diplom.annotation.Unique;
import com.diplom.enums.Gender;
import com.diplom.service.patient.PatientService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class PatientDto {

    @Email(message = "invalid.email")
    @NotBlank(message = "mandatory.email")
    @Unique(service = PatientService.class, fieldName = "email", message = "email.unique.violation")
    private String email;

    @PhoneNumber
    @NotBlank(message = "mandatory.phone")
    @Unique(service = PatientService.class, fieldName = "phoneNumber", message = "phone.unique.violation")
    private String phoneNumber;

    @NotBlank(message = "mandatory.firstName")
    private String firstName;

    @NotBlank(message = "mandatory.lastName")
    private String lastName;

    @NotNull(message = "patient.mandatory.birthDate")
    @Past(message = "patient.invalid.birthDate")
    private LocalDate birthDate;

    @NotNull(message = "patient.mandatory.gender")
    private Gender gender;

    private List<String> medicalHistory = new ArrayList<>();

    private List<String> currentMedications = new ArrayList<>();
}
