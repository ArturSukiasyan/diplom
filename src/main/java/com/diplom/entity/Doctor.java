package com.diplom.entity;

import com.diplom.annotation.PhoneNumber;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "doctor")
public class Doctor {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @NonNull
//    @Column(name = "username", nullable = false, unique = true)
//    private String username;
//
//    @NonNull
//    @Column(name = "password", nullable = false, unique = true)
//    private String password;

    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "specialty", nullable = false)
    private String specialty;

    @NonNull
    @Column(name = "yearsOfExperience", nullable = false)
    private Integer yearsOfExperience;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private List<Certificate> certificates = new ArrayList<>();

}
