package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.persistence.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();
    Usuario getOne(Usuario usuario);
    void save(Usuario usuario);
    void delete(Usuario usuario);

}
