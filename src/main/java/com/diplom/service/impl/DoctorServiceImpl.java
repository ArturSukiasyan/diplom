package com.diplom.service.impl;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.request.DoctorUpdateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.entity.Doctor;
import com.diplom.exception.DoctorNotFoundException;
import com.diplom.mapper.DoctorMapper;
import com.diplom.repository.DoctorRepository;
import com.diplom.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public boolean existByUsername(String username) {
        return doctorRepository.existsByUsername(username);
    }

    @Override
    public void delete(Long id) {
        log.info("Start deleting Doctor by id : {}", id);
        try {
            doctorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new DoctorNotFoundException(id);
        }
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
        log.info("Start updating Doctor by this data : {}", dto.toString());
        if (doctorRepository.findById(dto.getId()).isEmpty()) {
            throw new DoctorNotFoundException(dto.getId());
        }

        Doctor doctor = doctorRepository.save(doctorMapper.dtoToEntity(dto));
        log.info("Doctor successfully updated by id : {}", doctor.getId());

        return doctorMapper.entityToDto(doctor);
    }

    @Override
    public Optional<Doctor> findByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        switch (fieldName) {
            case "email":
                return doctorRepository.existsByEmail(value.toString());
            case "phoneNumber":
                return doctorRepository.existsByPhoneNumber(value.toString());
            case "username":
                return doctorRepository.existsByUsername(value.toString());
            default:
                throw new UnsupportedOperationException("Field name not supported");
        }
    }
}
