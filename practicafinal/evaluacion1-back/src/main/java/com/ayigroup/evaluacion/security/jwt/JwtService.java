package com.ayigroup.evaluacion.security.jwt;

import io.jsonwebtoken.JwtException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public interface JwtService {

    String getToken(UserDetails user);
    String getUsernameFromToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);

}
