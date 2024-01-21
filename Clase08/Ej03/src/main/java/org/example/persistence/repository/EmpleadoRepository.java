package org.example.persistence.repository;

import org.example.persistence.entity.Empleado;

import java.util.List;

public interface EmpleadoRepository {

    public List<Empleado> getAll();
    public Empleado getOne(String id);
    public void save(Empleado Empleados);
    public void update(Empleado Empleados);
    public void delete(Empleado Empleados);

}
