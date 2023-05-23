package com.diplom.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "visiting_date", nullable = false)
    private LocalDateTime visitingDate;

    @NotNull
    @Column(name = "doctor_id")
    private Long doctorId;

    @NotNull
    @Column(name = "patient_id")
    private Long patientId;
}
