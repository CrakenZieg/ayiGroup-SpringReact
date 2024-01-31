package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.EmpleadoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.EmpleadoDTO;
import com.ayigroup.evaluacion.persistence.entities.Empleado;
import com.ayigroup.evaluacion.persistence.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado getOne(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void create(EmpleadoCreateRequest dto) {
        empleadoRepository.save(createDtoToEmpleado(dto));
    }

    @Override
    @Transactional
    public void update(EmpleadoDTO dto) {
        empleadoRepository.save(dtoToEmpleado(dto));
    }

    @Override
    @Transactional
    public void delete(int id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if(empleado != null){
            empleadoRepository.delete(empleado);
        }
    }

    @Override
    public List<EmpleadoDTO> getAllDTO(){
        List<Empleado> empleados = getAll();
        if(!empleados.isEmpty()) {
            return empleados.stream().map(
                    (empleado) -> {
                        return new EmpleadoDTO(
                                empleado.getId(),
                                empleado.getNombre(),
                                empleado.getApellido(),
                                empleado.getCargo(),
                                empleado.getSucursal(),
                                empleado.getAntiguedad());

                    }).toList();
        }
        return new ArrayList<EmpleadoDTO>();
    }

    @Override
    public EmpleadoDTO getOneDTO(int id) {
        Empleado empleado = getOne(id);
        if(empleado!=null){
            return new EmpleadoDTO(
                    empleado.getId(),
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getCargo(),
                    empleado.getSucursal(),
                    empleado.getAntiguedad());
        }
        return null;
    }

    private Empleado dtoToEmpleado(EmpleadoDTO dto){
        return Empleado.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .apellido(dto.apellido())
                .cargo(dto.cargo())
                .sucursal(dto.sucursal())
                .antiguedad(dto.antiguedad())
                .build();
    }

    private Empleado createDtoToEmpleado(EmpleadoCreateRequest dto){
        return Empleado.builder()
                .nombre(dto.nombre())
                .apellido(dto.apellido())
                .cargo(dto.cargo())
                .sucursal(dto.sucursal())
                .antiguedad(dto.antiguedad())
                .build();
    }
}
