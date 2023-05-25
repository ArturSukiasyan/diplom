package com.diplom.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VisitDoctorResponse {

    private LocalDateTime visitingDate;
    private Long patientId;
}
