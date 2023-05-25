package com.diplom.service;

import com.diplom.dto.patient.request.PatientCreateRequestDto;
import com.diplom.dto.patient.request.PatientUpdateRequestDto;
import com.diplom.dto.patient.response.PatientResponseDto;
import com.diplom.entity.Patient;

import java.util.Optional;

public interface PatientService extends FieldValueExists {

    PatientResponseDto getById(Long id);

    void delete(Long id);

    PatientResponseDto create(PatientCreateRequestDto dto);

    PatientResponseDto update(PatientUpdateRequestDto dto);

    boolean existByUsername(String username);

    Optional<Patient> findByUsername(String username);
}
