package com.ayiGroup.instancia2.authentication;

import com.ayiGroup.instancia2.persistence.entities.Usuario;

public interface AuthenticationProvider {

    boolean getAuthentication(Usuario usuario);
    boolean isAuthenticated();
    boolean setAuthenticate(boolean value);

}
