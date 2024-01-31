package com.ayigroup.evaluacion.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Table(name="productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "codigo_ean")
    private String ean;
    @NotBlank(message = "El apellido no puede estar vacío")
    @Column(name = "nombre_producto")
    private String nombre;
    @NotBlank(message = "El cargo no puede estar vacío")
    @Column(name = "descripcion_producto")
    private String descripcion;
    @NotBlank(message = "La sucursal no puede estar vacío")
    private String tipo;
    @NotBlank(message = "La sucursal no puede estar vacío")
    private String marca;
    @Min(value = 0, message = "La antigüedad no puede ser menor a cero")
    private Double precio;
    @Min(value = 0, message = "La antigüedad no puede ser menor a cero")
    @Max(value = 1000, message = "La antigüedad no puede ser mayor a 1000")
    @Column(name = "precio")
    private Double stock;

    @PrePersist
    private void normalizeBranch(){
        this.sucursal = this.sucursal.toUpperCase();
    }

}
