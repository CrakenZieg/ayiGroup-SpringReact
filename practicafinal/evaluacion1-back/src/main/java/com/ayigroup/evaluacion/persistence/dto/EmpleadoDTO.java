package com.ayigroup.evaluacion.persistence.dto;

public record EmpleadoDTO(
        int id,
        String nombre,
        String apellido,
        String cargo,
        String sucursal,
        int antiguedad
) {
}
