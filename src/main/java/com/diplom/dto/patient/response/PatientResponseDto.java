package com.diplom.dto.patient.response;

import com.diplom.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PatientResponseDto {

    private Long id;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate birthDate;
    private Gender gender;

    private List<String> medicalHistory = new ArrayList<>();
    private List<String> currentMedications = new ArrayList<>();
}
