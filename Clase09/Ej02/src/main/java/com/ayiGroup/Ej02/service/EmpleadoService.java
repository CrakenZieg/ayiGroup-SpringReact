package com.ayiGroup.Ej02.service;

import com.ayiGroup.Ej02.persistence.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> getAll();
    Empleado getOne(String legajo);
    void save(Empleado empleados);
    void update(Empleado empleado);
    void delete(Empleado empleado);

}
