package com.ayigroup.ej03.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private float precio;

}
