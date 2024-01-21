package com.ayiGroup.instancia1.login.authenticators;

import com.ayiGroup.instancia1.login.Usuario;
import com.ayiGroup.instancia1.persistance.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationProviderImp implements AuthenticationProvider{

    private static boolean authenticated = false;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public boolean getAuthentication(Usuario usuario) {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        if(usuarios!=null){
            for (Usuario usuarioElem: usuarios) {
                if(usuarioElem.getNombre().equals(usuario.getNombre())
                        && usuarioElem.getPasswordUsuario().equals(usuario.getPasswordUsuario())){
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
