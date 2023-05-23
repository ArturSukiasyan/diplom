package com.diplom.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VisitRequest {

    @NotNull
    private LocalDateTime visitingDate;

    @NotNull
    private Long doctorId;
}
