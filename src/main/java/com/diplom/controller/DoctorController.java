package com.diplom.controller;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.service.doctor.DoctorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@Tag(name = "Doctor")
@RequiredArgsConstructor
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorResponseDto> createDoctor(@RequestBody @Valid DoctorCreateRequestDto dto) {
        DoctorResponseDto employeeResponseDto = doctorService.create(dto);
        return ResponseEntity.ok().body(employeeResponseDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorResponseDto> getDoctor(final @PathVariable("id") Long id) {
        DoctorResponseDto employeeResponseDto = doctorService.getById(id);
        return ResponseEntity.ok(employeeResponseDto);
    }


}
