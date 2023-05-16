package com.diplom.service.doctor;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.request.DoctorUpdateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.service.FieldValueExists;

public interface DoctorService extends FieldValueExists {

    DoctorResponseDto getById(Long id);

    void delete(Long id);

    DoctorResponseDto create(DoctorCreateRequestDto dto);

    DoctorResponseDto update(DoctorUpdateRequestDto dto);
}
