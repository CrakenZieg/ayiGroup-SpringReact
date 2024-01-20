package com.tp2.practica.entity;

import lombok.*;

//@ Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Clientes {

    private int nroCliente;
    private String nombre;
    private String apellido;
    private String telefono;

}
