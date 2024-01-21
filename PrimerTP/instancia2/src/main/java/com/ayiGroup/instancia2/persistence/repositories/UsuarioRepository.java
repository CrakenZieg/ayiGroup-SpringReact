package com.ayiGroup.instancia2.persistence.repositories;

import com.ayiGroup.instancia2.login.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
}
