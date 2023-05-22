package com.diplom.service.patient.impl;

import com.diplom.dto.patient.request.PatientCreateRequestDto;
import com.diplom.dto.patient.request.PatientUpdateRequestDto;
import com.diplom.dto.patient.response.PatientResponseDto;
import com.diplom.entity.Patient;
import com.diplom.exception.PatientNotFoundException;
import com.diplom.mapper.PatientMapper;
import com.diplom.repository.PatientRepository;
import com.diplom.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientResponseDto getById(Long id) {
        log.info("Getting Patient by id : {}", id);
        var patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            log.error("Failed to get Patient.");
            throw new PatientNotFoundException(id);
        } else {
            log.info("Patient was been getting successfully");
            return patientMapper.entityToDto(patient.get());
        }
    }

    @Override
    public void delete(Long id) {
        log.info("Start deleting Patient by id : {}", id);
        try {
            patientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new PatientNotFoundException(id);
        }
    }

    @Override
    public PatientResponseDto create(PatientCreateRequestDto dto) {
        log.info("Start saving Patient by this data : {}", dto.toString());
        Patient patient = patientRepository.save(patientMapper.dtoToEntity(dto));

        log.info("Patient successfully created by id : {}", patient.getId());

        return patientMapper.entityToDto(patient);
    }

    @Override
    public PatientResponseDto update(PatientUpdateRequestDto dto) {
        log.info("Start updating Patient by this data : {}", dto.toString());
        if (patientRepository.findById(dto.getId()).isEmpty()) {
            throw new PatientNotFoundException(dto.getId());
        }

        Patient patient = patientRepository.save(patientMapper.dtoToEntity(dto));
        log.info("Patient successfully updated by id : {}", patient.getId());

        return patientMapper.entityToDto(patient);
    }

    @Override
    public boolean existByUsername(String username) {
        return patientRepository.existsByUsername(username);
    }

    @Override
    public Optional<Patient> findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {

        switch (fieldName) {
            case "email":
                return patientRepository.existsByEmail(value.toString());
            case "phoneNumber":
                return patientRepository.existsByPhoneNumber(value.toString());
            case "username":
                return patientRepository.existsByUsername(value.toString());
            default:
                throw new UnsupportedOperationException("Field name not supported");
        }
    }
}
