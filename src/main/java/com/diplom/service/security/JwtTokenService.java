package com.diplom.service.security;

import org.springframework.security.core.Authentication;

public interface JwtTokenService {

    String generate(Authentication authentication);

    boolean validate(String authToken);

    String extractUsername(String token);
}
