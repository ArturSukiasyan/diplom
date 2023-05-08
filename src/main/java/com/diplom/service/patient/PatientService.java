package com.diplom.service.patient;

import com.diplom.dto.patient.request.PatientCreateRequestDto;
import com.diplom.dto.patient.request.PatientUpdateRequestDto;
import com.diplom.dto.patient.response.PatientResponseDto;
import com.diplom.service.FieldValueExists;

public interface PatientService extends FieldValueExists {

    PatientResponseDto getById(Long id);

    boolean delete(Long id);

    PatientResponseDto create(PatientCreateRequestDto dto);

    PatientResponseDto update(PatientUpdateRequestDto dto);
}
