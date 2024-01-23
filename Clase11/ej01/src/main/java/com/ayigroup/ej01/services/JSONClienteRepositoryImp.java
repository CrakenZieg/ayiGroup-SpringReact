package com.ayigroup.ej01.services;

import com.ayigroup.ej01.persistence.entities.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public class JSONClienteRepositoryImp implements ClienteService{

    private String filePath = "./clientes.json";

    @Override
    public Cliente getOne(int nroCliente) {
        List<Cliente> clientes = this.getAll();
        return clientes
                .stream()
                .filter((elem)->{return elem.getNroCliente()==nroCliente;})
                .toList()
                .getFirst();
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clientes = null;
        try {
            ObjectMapper om = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource(filePath);
            clientes = om.readValue(
                    resource.getInputStream(),
                    new TypeReference<List<Cliente>>(){}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    @Override
    public void save(Cliente cliente) {
    }

    @Override
    public void update(Cliente cliente) {
    }

    @Override
    public void delete(Cliente cliente) {
    }

}
