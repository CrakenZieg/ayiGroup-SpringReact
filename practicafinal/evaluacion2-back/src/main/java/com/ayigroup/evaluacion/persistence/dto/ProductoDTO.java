package com.ayigroup.evaluacion.persistence.dto;

public record ProductoDTO(
        int id,
        String ean,
        String nombre,
        String descripcion,
        String tipo,
        String marca,
        double precio,
        int stock
) {
}