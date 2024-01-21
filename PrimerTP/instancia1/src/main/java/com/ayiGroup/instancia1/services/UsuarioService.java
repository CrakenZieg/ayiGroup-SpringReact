package com.ayiGroup.instancia1.services;

import com.ayiGroup.instancia1.login.Usuario;
import com.ayiGroup.instancia1.persistance.repositories.IUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private static final Logger logger = LogManager.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public boolean validarCredenciales(String nombreUsuario, String password) {
        logger.info("Intentando validar credenciales para el usuario: {}", nombreUsuario);

        Usuario usuario = usuarioRepository.findByNombre(nombreUsuario);

        if (usuario != null && usuario.getPasswordUsuario().equals(password)) {
            logger.info("Credenciales válidas para el usuario: {}", nombreUsuario);
            return true;
        } else {
            logger.warn("Credenciales inválidas para el usuario: {}", nombreUsuario);
            return false;
        }
    }
}
