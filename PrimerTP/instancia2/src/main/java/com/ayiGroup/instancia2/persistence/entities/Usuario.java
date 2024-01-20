package com.ayiGroup.instancia2.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero_identificatorio")
    private Integer idUsuario;
    @NotEmpty(message= "El nombre no puede estar vacío")
    private String nombre;
    @NotEmpty(message= "La contraseña no puede estar en blanco")
    private String password;

}
