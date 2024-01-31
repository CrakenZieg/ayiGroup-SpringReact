package com.ayigroup.evaluacion.persistence.dto;

public record ClienteCreateRequest(
    String nombre,
    String apellido,
    String ingreso,
    String domicilio,
    String telefono
) {}
