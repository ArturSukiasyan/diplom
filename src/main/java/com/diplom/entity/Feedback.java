package com.diplom.entity;

import com.diplom.enums.Rating;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "review")
    private String review;

    @NotNull
    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @NotNull
    @Column(name = "doctor_id")
    private Long doctorId;

    @NotNull
    @Column(name = "patient_id")
    private Long patientId;
}


