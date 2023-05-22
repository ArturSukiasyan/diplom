package com.diplom.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private boolean isDoctor;
}
