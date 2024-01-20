package com.ayiGroup.Ej01.service;

import com.ayiGroup.Ej01.entity.Usuario2;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario2> getAll();
    public Usuario2 getOne(String id);
    public void save(Usuario2 usuario);
    public void delete(Usuario2 usuario);
}
