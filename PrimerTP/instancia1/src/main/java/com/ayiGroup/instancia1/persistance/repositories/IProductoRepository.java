package com.ayiGroup.instancia1.persistance.repositories;

import com.ayiGroup.instancia1.persistance.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoRepository extends CrudRepository<Producto, Integer> {

    boolean existsByCodigoEan(String codigoEan);

    boolean existsByNombre(String nombre);
}
