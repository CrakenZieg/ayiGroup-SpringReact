package org.example.repository;

import org.example.entity.Persona;

import java.util.List;
import java.util.UUID;

public interface PersonaRepository {

    public List<Persona> getAll();
    public Persona getOne(String id);
    public void save(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);

}
