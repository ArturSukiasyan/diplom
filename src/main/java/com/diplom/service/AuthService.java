package com.diplom.service;

import com.diplom.dto.security.AuthRequest;
import org.springframework.security.core.Authentication;

public interface AuthService {

    Authentication login(AuthRequest authRequest);
}
