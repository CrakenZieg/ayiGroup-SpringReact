package com.ayigroup.evaluacion.controller;

import com.ayigroup.evaluacion.persistence.dto.ProductoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.ProductoDTO;
import com.ayigroup.evaluacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<ProductoDTO>> all() {
        List<ProductoDTO> empleados = productoService.getAllDTO();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> one(@PathVariable int id) {
        return ResponseEntity.ok(productoService.getOneDTO(id));
    }

    @PostMapping("")
    public ResponseEntity<List<ProductoDTO>> post(@RequestBody ProductoCreateRequest producto) {
        productoService.create(producto);
        return all();
    }

    @PutMapping("")
    public ResponseEntity<List<ProductoDTO>> update(@RequestBody ProductoDTO producto) {
        productoService.update(producto);
        return all();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ProductoDTO>> delete(@PathVariable int id) {
        productoService.delete(id);
        return all();
    }
}