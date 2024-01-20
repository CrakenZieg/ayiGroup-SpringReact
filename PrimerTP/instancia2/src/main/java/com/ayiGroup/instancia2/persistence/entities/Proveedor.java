package com.ayiGroup.instancia2.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "proveedores")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigoProveedor;
    @NotEmpty(message= "El nombre no puede estar vacío")
    private String nombre;
    @NotEmpty(message= "El telefono no puede estar vacío")
    private String telefono;
    @NotEmpty(message= "La dirección no puede estar vacía")
    private String direccion;
    @NotEmpty(message= "El email debe ser válido")
    @Email
    private String email;
    @NotEmpty(message= "La web no puede estar vacía")
    private String web;
    @NotEmpty(message= "Debes elegir un estado para el proveedor")
    private Integer estado;

}