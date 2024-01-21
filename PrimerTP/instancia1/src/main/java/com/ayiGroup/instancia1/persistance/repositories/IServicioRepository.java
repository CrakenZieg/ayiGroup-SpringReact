package com.ayiGroup.instancia1.persistance.repositories;

import com.ayiGroup.instancia1.persistance.entities.Servicio;
import org.springframework.data.repository.CrudRepository;

public interface IServicioRepository extends CrudRepository<Servicio, Integer> {

    boolean existsByCodigoEan(String codigoEan);

    boolean existsByNombre(String nombre);
}
