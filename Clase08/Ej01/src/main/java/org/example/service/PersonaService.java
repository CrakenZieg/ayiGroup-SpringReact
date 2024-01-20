package org.example.service;

import org.example.entity.Persona;

import java.util.List;
import java.util.UUID;

public interface PersonaService {

    public List<Persona> getAll();
    public Persona getOne(String id);
    public void save(Persona persona);
    public void delete(Persona persona);

}
