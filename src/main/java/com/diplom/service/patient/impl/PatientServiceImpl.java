package com.diplom.service.patient.impl;

import com.diplom.repository.PatientRepository;
import com.diplom.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {

        if ("email".equals(fieldName)) {
            return patientRepository.existsByEmail(value.toString());
        } else if ("phoneNumber".equals(fieldName)) {
            return patientRepository.existsByPhoneNumber(value.toString());
        }

        throw new UnsupportedOperationException("Field name not supported");
    }
}
