package com.ayiGroup.instancia2.login.authentication;

import com.ayiGroup.instancia2.login.Usuario;
import com.ayiGroup.instancia2.persistence.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationProviderImp implements AuthenticationProvider{

    private static boolean authenticated = false;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean getAuthentication(Usuario usuario) {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        if(usuarios!=null){
            for (Usuario usuarioElem: usuarios) {
                if(usuarioElem.getNombre().equals(usuario.getNombre())
                        && usuarioElem.getPassword().equals(usuario.getPassword())){
                    authenticated = true;
                }
            }
        }
        return authenticated;
    }

    @Override
    public boolean isAuthenticated(){
        return authenticated;
    }

    @Override
    public boolean setAuthenticate(boolean value){
        authenticated = value;
        return authenticated;
    }

}
