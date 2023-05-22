package com.diplom.service.security;

import com.diplom.dto.security.AuthRequest;
import org.springframework.security.core.Authentication;

public interface AuthService {

    Authentication login(AuthRequest authRequest);
}
