package com.diplom.dto.doctor.response;

import com.diplom.entity.Certificate;
import com.diplom.entity.Education;
import com.diplom.entity.Experience;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorResponseDto {

    private Long id;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String username;
    private String password;
    private String lastName;
    private String description;
    private String specialty;
    private Integer yearsOfExperience;

    private List<Education> educations = new ArrayList<>();
    private List<Experience> experiences = new ArrayList<>();
    private List<Certificate> certificates = new ArrayList<>();
}
