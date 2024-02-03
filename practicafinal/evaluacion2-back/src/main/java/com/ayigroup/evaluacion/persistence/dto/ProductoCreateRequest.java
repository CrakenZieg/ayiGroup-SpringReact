package com.ayigroup.evaluacion.persistence.dto;

public record ProductoCreateRequest(
        String ean,
        String nombre,
        String descripcion,
        String tipo,
        String marca,
        double precio,
        int stock
) {
}
