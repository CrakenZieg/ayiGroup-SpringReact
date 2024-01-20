package com.ayiGroup.Ej02.persistence.repository;

import com.ayiGroup.Ej02.persistence.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,String> {
}
