package com.diplom.controller;

import com.diplom.dto.security.AuthRequest;
import com.diplom.service.security.AuthService;
import com.diplom.service.security.JwtTokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Auth")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final JwtTokenService jwtTokenService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid AuthRequest request) {
        try {
            var authenticate = authService.login(request);
            String token = jwtTokenService.generate(authenticate);
            return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .build();
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
