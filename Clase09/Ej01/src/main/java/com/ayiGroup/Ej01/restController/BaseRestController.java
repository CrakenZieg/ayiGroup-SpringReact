package com.ayiGroup.Ej01.restController;

import com.ayiGroup.Ej01.entity.Usuario2;
import com.ayiGroup.Ej01.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BaseRestController {

    private static final Logger logger = LoggerFactory.getLogger(BaseRestController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario2>> baseApi(){
        logger.info("Request a url api base!");
        return ResponseEntity.ok(usuarioService.getAll());
    }

}
