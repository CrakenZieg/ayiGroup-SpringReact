package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.EmpleadoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.EmpleadoDTO;
import com.ayigroup.evaluacion.persistence.entities.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadoService {

    List<Empleado> getAll();

    Empleado getOne(int id);

    void create(EmpleadoCreateRequest empleadoDTO);

    void update(EmpleadoDTO empleadoDTO);

    void delete(int id);

    List<EmpleadoDTO> getAllDTO();

    EmpleadoDTO getOneDTO(int id);

}

