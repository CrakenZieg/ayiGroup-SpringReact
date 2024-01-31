package com.ayigroup.evaluacion.security.auth;

import com.ayigroup.evaluacion.security.dto.AuthResponse;
import com.ayigroup.evaluacion.security.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    AuthResponse login(LoginRequest request);

}
