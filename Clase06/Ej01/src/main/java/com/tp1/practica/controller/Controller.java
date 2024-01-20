package com.tp1.practica.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${mensaje}")
    private String mensaje;

    @GetMapping("/")
    public String base(){
        String out = mensaje;
        return out;
    }
    @GetMapping("/{nombres}")
    public String baseNombres(@PathVariable String[] nombres){
        String out = mensaje;
        if(nombres.length>0){
            out = out.concat("... Lo cursan: ");
            for (String nombre: nombres) {
                out = out.concat(nombre+", ");
            }
        }
        return out;
    }

}
