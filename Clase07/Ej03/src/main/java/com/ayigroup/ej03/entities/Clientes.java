package com.ayigroup.ej03.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {

    private int nroCliente;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    private String email;

}
