package com.ayigroup.evaluacion.security.dto;

public record LoginRequest(
        String username,
        String password
) {}
