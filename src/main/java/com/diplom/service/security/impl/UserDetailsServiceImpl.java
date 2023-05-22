package com.diplom.service.security.impl;

import com.diplom.dto.security.UserDetailsDto;
import com.diplom.enums.Roles;
import com.diplom.service.doctor.DoctorService;
import com.diplom.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var doctor = doctorService.findByUsername(username);
        var patient = patientService.findByUsername(username);
        if (doctor.isPresent()) {
            return UserDetailsDto.builder()
                .username(doctor.get().getUsername())
                .password(passwordEncoder.encode(doctor.get().getPassword()))
                .authorities(List.of(new SimpleGrantedAuthority(Roles.ROLE_DOCTOR)))
                .build();
        } else if (patient.isPresent()) {
            return UserDetailsDto.builder()
                .username(patient.get().getUsername())
                .password(passwordEncoder.encode(patient.get().getPassword()))
                .authorities(List.of(new SimpleGrantedAuthority(Roles.ROLE_PATIENT)))
                .build();
        } else {
            throw new UsernameNotFoundException("User not found by this username :" + username);
        }
    }
}
