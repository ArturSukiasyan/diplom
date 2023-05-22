package com.diplom.controller;

import com.diplom.dto.patient.request.PatientCreateRequestDto;
import com.diplom.dto.patient.request.PatientUpdateRequestDto;
import com.diplom.dto.patient.response.PatientResponseDto;
import com.diplom.enums.Roles;
import com.diplom.service.patient.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Slf4j
@RestController
@Tag(name = "Patient")
@RequiredArgsConstructor
@RequestMapping(value = "/patient")
@PreAuthorize("hasRole('PATIENT')")
@RolesAllowed(Roles.ROLE_PATIENT)
public class PatientController {

    private final PatientService patientService;

    @PutMapping(
        value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PatientResponseDto> updatePatient(@RequestBody @Valid PatientUpdateRequestDto dto) {
        PatientResponseDto patient = patientService.update(dto);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientResponseDto> getPatient(final @PathVariable("id") Long id) {
        PatientResponseDto patient = patientService.getById(id);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePatient(final @PathVariable("id") Long id) {
        patientService.delete(id);
        return ResponseEntity.status(200).build();
    }


    @PostMapping(
        value = "/register-patient", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("permitAll()")
    public ResponseEntity<PatientResponseDto> createPatient(@RequestBody @Valid PatientCreateRequestDto dto) {
        PatientResponseDto patient = patientService.create(dto);
        return ResponseEntity.ok().body(patient);
    }

}
