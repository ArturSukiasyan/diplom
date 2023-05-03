package com.diplom.entity;

import com.diplom.annotation.PhoneNumber;
import com.diplom.enums.Gender;
import com.diplom.util.ConverterUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Patient")
public class Patient {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Email
    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @PhoneNumber
    @NonNull
    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @NonNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NonNull
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @NonNull
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Positive
    @NonNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Convert(converter = ConverterUtil.class)
    private List<String> medicalHistory = new ArrayList<>();

    @Convert(converter = ConverterUtil.class)
    private List<String> currentMedications = new ArrayList<>();

}
