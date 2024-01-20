package com.ayiGroup.Ej02.persistence.repository;

import com.ayiGroup.Ej02.persistence.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRespository extends JpaRepository<Sucursal,Integer> {
}
