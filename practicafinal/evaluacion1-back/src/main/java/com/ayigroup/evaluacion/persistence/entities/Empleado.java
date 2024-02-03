package com.ayigroup.evaluacion.persistence.entities;

import jakarta.persistence.*;
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
@Table(name="empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "legajo")
    private int id;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "nombre_empleado")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacío")
    @Column(name = "apellido_empleado")
    private String apellido;
    @NotBlank(message = "El cargo no puede estar vacío")
    private String cargo;
    @NotBlank(message = "La sucursal no puede estar vacío")
    private String sucursal;
    @Min(value = 0, message = "La antigüedad no puede ser menor a cero")
    @Column(name = "antiguedad_anios")
    private int antiguedad;

    @PrePersist
    private void normalizeBranch(){
        this.sucursal = this.sucursal.replace(" ","").toUpperCase();
    }



}
