package com.ayigroup.evaluacion.security.auth;

import com.ayigroup.evaluacion.security.dto.AuthResponse;
import com.ayigroup.evaluacion.security.dto.LoginRequest;
import com.ayigroup.evaluacion.security.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        return null;
    }
}
