package com.diplom.service.doctor.impl;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.request.DoctorUpdateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.entity.Doctor;
import com.diplom.exception.DoctorNotFoundException;
import com.diplom.mapper.DoctorMapper;
import com.diplom.repository.DoctorRepository;
import com.diplom.repository.PatientRepository;
import com.diplom.service.doctor.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponseDto getById(Long id) {
        log.info("Getting Doctor by id : {}", id);
        var doctor = doctorRepository.findById(id);
        if (doctor.isEmpty()) {
            log.error("Failed to get Doctor.");
            throw new DoctorNotFoundException(id);
        } else {
            log.info("Doctor was been getting successfully");
            return doctorMapper.entityToDto(doctor.get());
        }
    }

    @Override
    public boolean delete(Long id) {
        //todo
        return true;
    }

    @Override
    public DoctorResponseDto create(DoctorCreateRequestDto dto) {
        log.info("Start saving Doctor by this data : {}", dto.toString());
        Doctor doctor = doctorRepository.save(doctorMapper.dtoToEntity(dto));

        log.info("Doctor successfully created by id : {}", doctor.getId());

        return doctorMapper.entityToDto(doctor);

    }

    @Override
    public DoctorResponseDto update(DoctorUpdateRequestDto dto) {
        //todo
        return null;
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {

        if ("email".equals(fieldName)) {
            return doctorRepository.existsByEmail(value.toString());
        } else if ("phoneNumber".equals(fieldName)) {
            return doctorRepository.existsByPhoneNumber(value.toString());
        }

        throw new UnsupportedOperationException("Field name not supported");
    }
}
