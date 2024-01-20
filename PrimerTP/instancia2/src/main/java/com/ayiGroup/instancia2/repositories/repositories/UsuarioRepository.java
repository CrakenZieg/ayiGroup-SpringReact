package com.ayiGroup.instancia2.repositories.repositories;

import com.ayiGroup.instancia2.repositories.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
}
