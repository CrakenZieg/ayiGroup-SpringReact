package com.ayigroup.ej01.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero_de_cliente")
    private int nroCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String domicilio;

}
