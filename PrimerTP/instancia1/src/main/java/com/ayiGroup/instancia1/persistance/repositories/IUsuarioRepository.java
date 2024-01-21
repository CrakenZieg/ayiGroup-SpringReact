package com.ayiGroup.instancia1.persistance.repositories;

import com.ayiGroup.instancia1.login.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByNombre(String nombreUsuario);
}
