package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.login.Usuario;
import com.ayiGroup.instancia2.persistence.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario getOne(Usuario usuario) {
        return usuarioRepository.findById(usuario.getIdUsuario()).orElseGet(()->{return null;});
    }

}
