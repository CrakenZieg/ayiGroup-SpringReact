package com.ayigroup.evaluacion.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;
    @NotBlank(message = "El código ean no puede estar vacío")
    @Column(name = "codigo_ean")
    private String ean;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "nombre_producto")
    private String nombre;
    @NotBlank(message = "La descripción no puede estar vacío")
    @Column(name = "descripcion_producto")
    private String descripcion;
    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;
    @NotBlank(message = "La marca no puede estar vacío")
    private String marca;
    @Positive(message = "El precio no puede ser menor o igual a cero")
    @Max(value = 1000, message = "El precio no puede ser mayor o igual a 1000")
    private double precio;
    @PositiveOrZero(message = "El stock no puede ser menor a cero")
    private int stock;

    @PrePersist
    @PreUpdate
    private void normalizeBranch() {
        this.precio = (Math.floor(this.precio * 100)) / 100;
    }

}
