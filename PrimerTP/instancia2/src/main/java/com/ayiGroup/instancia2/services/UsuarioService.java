package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.login.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();
    Usuario getOne(Usuario usuario);

}
