package org.example.repository;

import org.example.entity.Clientes;

import java.util.List;

public interface ClientesRepository {

    public List<Clientes> getAll();
    public Clientes getOne(int id);
    public void save(Clientes clientes);
    public void update(Clientes clientes);
    public void delete(Clientes clientes);

}
