package com.ayiGroup.instancia1.login.authenticators;

import com.ayiGroup.instancia1.login.Usuario;

public interface AuthenticationProvider {

    boolean getAuthentication(Usuario usuario);
    boolean isAuthenticated();
    boolean setAuthenticate(boolean value);
}
