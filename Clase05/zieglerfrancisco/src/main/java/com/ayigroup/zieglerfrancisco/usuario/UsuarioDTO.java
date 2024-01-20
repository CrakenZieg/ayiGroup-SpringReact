
package com.ayigroup.zieglerfrancisco.usuario;

public record UsuarioDTO(
        int idUsuario,
        String nombreUsuario,
        String password,
        int persona,
        int tipoUsuario
        ) {}