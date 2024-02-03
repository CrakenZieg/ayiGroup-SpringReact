package com.ayigroup.evaluacion.persistence.dto;

public record EmpleadoCreateRequest(
        String nombre,
        String apellido,
        String cargo,
        String sucursal,
        int antiguedad
) {
}