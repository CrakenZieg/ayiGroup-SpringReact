package com.ayiGroup.instancia2.repositories.repositories;

import com.ayiGroup.instancia2.repositories.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProovedorRepository extends CrudRepository<Proveedor,Integer> {
}
