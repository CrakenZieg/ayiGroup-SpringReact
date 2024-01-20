package com.ayiGroup.Ej01.service;

import com.ayiGroup.Ej01.Ej01Application;
import com.ayiGroup.Ej01.entity.Usuario2;
import com.ayiGroup.Ej01.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario2> getAll() {
        logger.info("Llamada a UsuarioServiceImp.getAll()");
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario2 getOne(String id) {
        Optional<Usuario2> opt = usuarioRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario2 usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario2 usuario) {
        usuarioRepository.delete(usuario);
    }
}
