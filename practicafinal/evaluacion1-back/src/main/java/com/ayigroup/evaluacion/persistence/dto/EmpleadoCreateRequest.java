package com.ayigroup.evaluacion.persistence.dto;

import com.ayigroup.evaluacion.persistence.entities.Empleado;

public record EmpleadoCreateRequest(
        String nombre,
        String apellido,
        String cargo,
        String sucursal,
        int antiguedad
) {}