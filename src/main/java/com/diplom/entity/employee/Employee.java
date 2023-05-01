package com.diplom.entity.employee;

import com.diplom.enums.Availability;
import com.diplom.enums.Level;
import com.diplom.enums.Presence;
import com.diplom.util.ConverterUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Nullable
    @Column(name = "phone_number")
    private String phoneNumber;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "hidden_number", columnDefinition = "boolean default false")
    private Boolean hiddenNumber = false;

    @NonNull
    @Column(name = "experience_level")
    @Enumerated(EnumType.STRING)
    private Level level;

    @NonNull
    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @NonNull
    @Column(name = "presence")
    @Enumerated(EnumType.STRING)
    private Presence presence;

    @NonNull
    @Column(name = "title", nullable = false)
    private String title;

    @Nullable
    @Column(name = "description")
    private String description;

    @Nullable
    @Column(name = "profile_photo_name", nullable = false)
    private String profilePhotoName;

    @Nullable
    @Column(name = "cv_name", nullable = false)
    private String cvName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Language> languages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Certificate> certificates = new ArrayList<>();

    @Convert(converter = ConverterUtil.class)
    private List<String> skills = new ArrayList<>();

}
