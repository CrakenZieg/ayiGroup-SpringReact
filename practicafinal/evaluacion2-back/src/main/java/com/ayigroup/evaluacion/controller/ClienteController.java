package com.ayigroup.evaluacion.controller;

import com.ayigroup.evaluacion.persistence.dto.ClienteCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.ClienteDTO;
import com.ayigroup.evaluacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<ClienteDTO>> all(){
        List<ClienteDTO> clientes = clienteService.getAllDTO();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> one(@PathVariable int id){
        return ResponseEntity.ok(clienteService.getOneDTO(id));
    }

    @PostMapping("")
    public ResponseEntity<List<ClienteDTO>> post(@RequestBody ClienteCreateRequest cliente){
        clienteService.create(cliente);
        return all();
    }

    @PutMapping("")
    public ResponseEntity<List<ClienteDTO>> update(@RequestBody ClienteDTO cliente){
        clienteService.update(cliente);
        return all();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ClienteDTO>> delete(@PathVariable int id){
        clienteService.delete(id);
        return all();
    }
}