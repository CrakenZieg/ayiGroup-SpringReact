package com.ayiGroup.instancia2.login.authentication;

import com.ayiGroup.instancia2.login.Usuario;

public interface AuthenticationProvider {

    boolean getAuthentication(Usuario usuario);
    boolean isAuthenticated();
    boolean setAuthenticate(boolean value);

}
