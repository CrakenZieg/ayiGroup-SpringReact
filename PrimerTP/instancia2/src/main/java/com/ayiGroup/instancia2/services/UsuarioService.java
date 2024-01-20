package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.repositories.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();
    Usuario getOne(int idUsuario);
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(Usuario usuario);

}
