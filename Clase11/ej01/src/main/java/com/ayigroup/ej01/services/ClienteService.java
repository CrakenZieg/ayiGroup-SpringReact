package com.ayigroup.ej01.services;

import com.ayigroup.ej01.persistence.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAll();
    Cliente getOne(int nroCliente);
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Cliente cliente);

}
