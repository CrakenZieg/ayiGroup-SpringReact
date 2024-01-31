package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.EmpleadoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.EmpleadoDTO;
import com.ayigroup.evaluacion.persistence.entities.Empleado;
import com.ayigroup.evaluacion.persistence.repositories.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> getAll() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado getOne(int id) {
        return empleadoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void create(EmpleadoCreateRequest dto) {
        empleadoRepositorio.save(createDtoToEmpleado(dto));
    }

    @Override
    public void update(EmpleadoDTO dto) {
        empleadoRepositorio.save(dtoToEmpleado(dto));
    }

    @Override
    public void delete(int id) {
        Empleado empleado = empleadoRepositorio.findById(id).orElse(null);
        if(empleado != null){
            empleadoRepositorio.delete(empleado);
        }
    }

    @Override
    public List<EmpleadoDTO> getAllDTO(){
        List<EmpleadoDTO> empleados = new ArrayList<>();
        empleados.addAll(getAll().stream().map(
                (empleado) -> {
                    return new EmpleadoDTO(
                            empleado.getId(),
                            empleado.getNombre(),
                            empleado.getApellido(),
                            empleado.getCargo(),
                            empleado.getSucursal(),
                            empleado.getAntiguedad());

                }).toList());
        return empleados;
    }

    @Override
    public EmpleadoDTO getOneDTO(int id) {
        Empleado empleado = getOne(id);
        return new EmpleadoDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getCargo(),
                empleado.getSucursal(),
                empleado.getAntiguedad());
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
