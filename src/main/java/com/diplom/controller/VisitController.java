package com.diplom.controller;

import com.diplom.dto.security.VisitDoctorResponse;
import com.diplom.dto.security.VisitPatientResponse;
import com.diplom.dto.security.VisitRequest;
import com.diplom.service.VisitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Tag(name = "Visit")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/visit")
public class VisitController {

    private final VisitService visitService;

    @PostMapping("/{pid}/reserve")
    @Secured ("ROLE_PATIENT")
    public ResponseEntity<Void> reserve(@PathVariable Long pid,
                                        @RequestBody @Valid VisitRequest request) {

        visitService.reserve(pid, request);
        return ResponseEntity.status(200).build();

    }

    @DeleteMapping("/delete")
    @Secured ({"ROLE_DOCTOR", "ROLE_PATIENT"})
    public ResponseEntity<Void> delete(@NotNull Long visitId) {

        visitService.delete(visitId);
        return ResponseEntity.status(200).build();

    }

    @GetMapping("/getDoctorVisits")
    @Secured ("ROLE_DOCTOR")
    public ResponseEntity<List<VisitDoctorResponse>> getDoctorVisits(@NotNull Long did) {
        return ResponseEntity.ok(visitService.getDoctorVisits(did));
    }

    @GetMapping("/getPatientVisits")
    @Secured ("ROLE_DOCTOR")
    public ResponseEntity<List<VisitPatientResponse>> getPatientVisits(@NotNull Long pid) {
        return ResponseEntity.ok(visitService.getPatientVisits(pid));
    }

}
