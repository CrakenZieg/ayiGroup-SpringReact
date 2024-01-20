package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Clientes;
import org.example.repository.ClientesRepository;
import org.example.repository.ClientesRepositoryImp;

import java.util.List;

public class ClientesServiceImpl implements ClientesService {

    private static final Logger logger = LogManager.getLogger(ClientesServiceImpl.class);
    private ClientesRepository clientesRepository = new ClientesRepositoryImp();

    public List<Clientes> getAll(){
        logger.info("Llamado al getAll()");
        return clientesRepository.getAll();
    }

    public Clientes getOne(int id){
        logger.info("Llamado al getOne("+id+")");
        return clientesRepository.getOne(id);
    }

    public void save(Clientes clientes){
        logger.info("Llamado al save("+ clientes.toString()+")");
        if(clientes.getIdCliente()!=0){
            clientesRepository.update(clientes);
        }else{
            clientesRepository.save(clientes);
        }
    }

    public void delete(Clientes clientes){
        logger.info("Llamado al delete("+ clientes.getIdCliente()+")");
        if(clientes.getIdCliente()!=0){
            clientesRepository.delete(clientes);
        }
    }

}
