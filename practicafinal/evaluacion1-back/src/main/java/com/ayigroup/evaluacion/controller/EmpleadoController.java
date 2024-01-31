package com.ayigroup.evaluacion.controller;

import com.ayigroup.evaluacion.persistence.dto.EmpleadoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.EmpleadoDTO;
import com.ayigroup.evaluacion.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<List<EmpleadoDTO>> all(){
        List<EmpleadoDTO> empleados = empleadoService.getAllDTO();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> one(@PathVariable int id){
        return ResponseEntity.ok(empleadoService.getOneDTO(id));
    }

    @PostMapping("")
    public ResponseEntity<List<EmpleadoDTO>> post(@RequestBody EmpleadoCreateRequest empleado){
        empleadoService.create(empleado);
        return all();
    }

    @PutMapping("")
    public ResponseEntity<List<EmpleadoDTO>> update(@RequestBody EmpleadoDTO empleado){
        empleadoService.update(empleado);
        return all();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<EmpleadoDTO>> delete(@PathVariable int id){
        empleadoService.delete(id);
        return all();
    }

}