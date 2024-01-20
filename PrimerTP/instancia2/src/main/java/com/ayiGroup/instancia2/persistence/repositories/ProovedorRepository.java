package com.ayiGroup.instancia2.persistence.repositories;

import com.ayiGroup.instancia2.persistence.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProovedorRepository extends CrudRepository<Proveedor,Integer> {
}
