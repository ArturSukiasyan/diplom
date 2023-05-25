package com.diplom.service.impl;

import com.diplom.dto.security.AuthRequest;
import com.diplom.enums.Roles;
import com.diplom.service.DoctorService;
import com.diplom.service.PatientService;
import com.diplom.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Override
    public Authentication login(AuthRequest authRequest) {

        boolean isUserExists;
        String role;
        String username = authRequest.getUsername();
        if (authRequest.isDoctor()) {
            isUserExists = doctorService.existByUsername(username);
            role = Roles.ROLE_DOCTOR;
        } else {
            isUserExists = patientService.existByUsername(username);
            role = Roles.ROLE_PATIENT;
        }

        if (!isUserExists) {
            throw new UsernameNotFoundException("User not found by this username : " + username);
        }

        var token = new UsernamePasswordAuthenticationToken(
            username,
            authRequest.getPassword(),
            List.of(new SimpleGrantedAuthority(role))
        );

        return authenticationManager.authenticate(token);
    }
}
