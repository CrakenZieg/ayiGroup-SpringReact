package com.tp3.practica.entity;

import lombok.*;

//@ Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Empleados {

    private int legajo;
    private String nombre;
    private String apellido;
    private int antiguedad;

}
