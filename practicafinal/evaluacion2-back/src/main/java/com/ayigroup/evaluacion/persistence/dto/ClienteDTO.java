package com.ayigroup.evaluacion.persistence.dto;

public record ClienteDTO(
        int id,
        String nombre,
        String apellido,
        String ingreso,
        String domicilio,
        String telefono
) {}
