package com.ayigroup.evaluacion.persistence.repositories;

import com.ayigroup.evaluacion.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
