package com.ayigroup.evaluacion.persistence.repositories;

import com.ayigroup.evaluacion.persistence.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio  extends JpaRepository<Empleado,Integer> {
}
