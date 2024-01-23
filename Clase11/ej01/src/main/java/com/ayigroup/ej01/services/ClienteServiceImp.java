package com.ayigroup.ej01.services;

import com.ayigroup.ej01.persistence.entities.Cliente;
import com.ayigroup.ej01.persistence.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getOne(int nroCliente) {
        return clienteRepository.getOne(nroCliente);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

}
