package com.ayiGroup.instancia2.persistence.entities;

import jakarta.persistence.*;
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
    private int codigoProveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String web;
    private int estado;

}