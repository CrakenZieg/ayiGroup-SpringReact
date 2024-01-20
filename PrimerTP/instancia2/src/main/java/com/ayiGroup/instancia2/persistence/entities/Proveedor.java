package com.ayiGroup.instancia2.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    @NotBlank(message= "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message= "El telefono no puede estar vacío")
    private String telefono;
    @NotBlank(message= "La dirección no puede estar vacía")
    private String direccion;
    @NotBlank(message= "El email debe ser válido")
    @Email
    private String email;
    @NotBlank(message= "La web no puede estar vacía")
    @Column(name = "sitio_web")
    private String web;
    private int estado;

}