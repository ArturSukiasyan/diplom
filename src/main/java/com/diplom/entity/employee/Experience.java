package com.diplom.entity.employee;

import com.diplom.enums.Availability;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "experience")
public class Experience {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Nullable
    @Column(name = "end_date")
    private LocalDate endDate;

    @Nullable
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "title", nullable = false)
    private String title;

    @NonNull
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private Availability availability;

}
