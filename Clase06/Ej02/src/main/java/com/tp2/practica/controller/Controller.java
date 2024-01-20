package com.tp2.practica.controller;

import com.tp2.practica.entity.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<Map<Integer, Clientes>> base(){
        HashMap<Integer, Clientes> clients = new HashMap<>();
        clients.put(1, new Clientes(1,"pepe1","apepe1","123-456"));
        clients.put(2, new Clientes(2,"pepe2","apepe2","234-567"));
        clients.put(3, new Clientes(3,"pepe3","apepe3","345-678"));
        clients.put(4, new Clientes(4,"pepe4","apepe4","456-789"));
        return ResponseEntity.ok(clients);
    }

}
