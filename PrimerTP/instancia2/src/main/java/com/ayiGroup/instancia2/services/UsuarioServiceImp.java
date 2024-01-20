package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.persistence.entities.Usuario;
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
    public Usuario getOne(int idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseGet(()->{return null;});
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
