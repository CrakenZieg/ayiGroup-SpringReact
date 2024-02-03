package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.ClienteCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.ClienteDTO;
import com.ayigroup.evaluacion.persistence.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<Cliente> getAll();

    Cliente getOne(int id);

    void create(ClienteCreateRequest dto);

    void update(ClienteDTO dto);

    void delete(int id);

    List<ClienteDTO> getAllDTO();

    ClienteDTO getOneDTO(int id);

}
