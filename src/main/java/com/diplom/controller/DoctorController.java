package com.diplom.controller;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.request.DoctorUpdateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.dto.subclasses.response.FeedbackResponseDto;
import com.diplom.enums.Roles;
import com.diplom.service.DoctorService;
import com.diplom.service.FeedbackService;
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
import java.util.List;

@Slf4j
@RestController
@Tag(name = "Doctor")
@RequiredArgsConstructor
@RequestMapping(value = "/doctor")
@PreAuthorize("hasRole('DOCTOR')")
@RolesAllowed(Roles.ROLE_DOCTOR)
public class DoctorController {

    private final DoctorService doctorService;
    private final FeedbackService feedbackService;

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorResponseDto> updateDoctor(@RequestBody @Valid DoctorUpdateRequestDto dto) {
        DoctorResponseDto doctor = doctorService.update(dto);
        return ResponseEntity.ok().body(doctor);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorResponseDto> getDoctor(final @PathVariable("id") Long id) {
        DoctorResponseDto doctor = doctorService.getById(id);
        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDoctor(final @PathVariable("id") Long id) {
        doctorService.delete(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/{id}/feedback")
    public ResponseEntity<List<FeedbackResponseDto>> getDoctorFeedbacks(final @PathVariable("id") Long doctorId) {
        List<FeedbackResponseDto> feedbacks = feedbackService.getDoctorFeedbacks(doctorId);
        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping(
        value = "/register-doctor", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DoctorResponseDto> createDoctor(@RequestBody @Valid DoctorCreateRequestDto dto) {
        DoctorResponseDto doctor = doctorService.create(dto);
        return ResponseEntity.ok().body(doctor);
    }
}
