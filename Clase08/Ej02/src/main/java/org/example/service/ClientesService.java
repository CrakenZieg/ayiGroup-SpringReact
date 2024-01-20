package org.example.service;

import org.example.entity.Clientes;

import java.util.List;

public interface ClientesService {

    public List<Clientes> getAll();
    public Clientes getOne(int id);
    public void save(Clientes clientes);
    public void delete(Clientes clientes);

}
