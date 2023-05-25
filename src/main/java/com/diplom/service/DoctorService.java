package com.diplom.service;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.request.DoctorUpdateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.entity.Doctor;

import java.util.Optional;

public interface DoctorService extends FieldValueExists {

    DoctorResponseDto getById(Long id);

    boolean existByUsername(String username);

    void delete(Long id);

    DoctorResponseDto create(DoctorCreateRequestDto dto);

    DoctorResponseDto update(DoctorUpdateRequestDto dto);

    Optional<Doctor> findByUsername(String username);
}
