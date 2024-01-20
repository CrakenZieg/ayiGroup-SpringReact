package com.ayiGroup.Ej01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario2 {

    @Id
    @GeneratedValue (generator= "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String idUsuario;
    private String nombre;
    private String apellido;

}
