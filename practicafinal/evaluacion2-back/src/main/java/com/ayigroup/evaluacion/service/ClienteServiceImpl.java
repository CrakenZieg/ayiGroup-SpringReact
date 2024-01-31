package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.ClienteCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.ClienteDTO;
import com.ayigroup.evaluacion.persistence.entities.Cliente;
import com.ayigroup.evaluacion.persistence.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getOne(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void create(ClienteCreateRequest dto) {
        clienteRepository.save(createDtoToCliente(dto));
    }

    @Override
    @Transactional
    public void update(ClienteDTO dto) {
        clienteRepository.save(dtoToCliente(dto));
    }

    @Override
    @Transactional
    public void delete(int id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente!=null){
            clienteRepository.delete(cliente);
        }
    }

    @Override
    public List<ClienteDTO> getAllDTO() {
        List<Cliente> clientes = getAll();
        if(!clientes.isEmpty()){
            return clientes.stream().map(
                    (cliente) -> {
                        return new ClienteDTO(
                                cliente.getId(),
                                cliente.getNombre(),
                                cliente.getApellido(),
                                cliente.getIngreso(),
                                cliente.getDomicilio(),
                                cliente.getTelefono()
                        );
            }).toList();
        }
        return new ArrayList<ClienteDTO>();
    }

    @Override
    public ClienteDTO getOneDTO(int id) {
        Cliente cliente = getOne(id);
        if(cliente!=null){
            return new ClienteDTO(
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getIngreso(),
                    cliente.getDomicilio(),
                    cliente.getTelefono()
            );
        }
        return null;
    }

    private Cliente dtoToCliente(ClienteDTO dto){
        return Cliente.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .apellido(dto.apellido())
                .ingreso(dto.ingreso())
                .domicilio(dto.domicilio())
                .telefono(dto.telefono())
                .build();
    }

    private Cliente createDtoToCliente(ClienteCreateRequest dto){
        return Cliente.builder()
                .nombre(dto.nombre())
                .apellido(dto.apellido())
                .ingreso(dto.ingreso())
                .domicilio(dto.domicilio())
                .telefono(dto.telefono())
                .build();
    }
}
