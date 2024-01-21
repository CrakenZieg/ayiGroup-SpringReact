package org.example.service;

import org.example.persistence.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> getAll();
    public Empleado getOne(String id);
    public void save(Empleado clientes);
    public void delete(Empleado clientes);

}
