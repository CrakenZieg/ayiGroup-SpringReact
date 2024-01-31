package com.ayigroup.evaluacion.security.auth;

import com.ayigroup.evaluacion.security.dto.AuthResponse;
import com.ayigroup.evaluacion.security.dto.LoginRequest;
import com.ayigroup.evaluacion.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        String token = null;
        if(request.username()!=null){
            UserDetails user = userDetailsService.loadUserByUsername(request.username());
            token = jwtService.getToken(user);
        }
        return new AuthResponse(token);
    }

}
