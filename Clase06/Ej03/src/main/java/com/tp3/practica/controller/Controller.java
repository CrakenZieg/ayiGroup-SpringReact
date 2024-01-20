package com.tp3.practica.controller;

import com.tp3.practica.entity.Empleados;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<LinkedList<Empleados>> base(){
        LinkedList<Empleados> empleados = new LinkedList<>();
        empleados.add(new Empleados(1,"pepe1","apepe1",5));
        empleados.add(new Empleados(2,"pepe2","apepe2",10));
        empleados.add(new Empleados(3,"pepe3","apepe3",15));
        empleados.add(new Empleados(4,"pepe4","apepe4",20));
        return ResponseEntity.ok(empleados);
    }

}
