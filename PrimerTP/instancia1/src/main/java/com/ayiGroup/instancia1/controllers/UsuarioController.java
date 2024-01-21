package com.ayiGroup.instancia1.controllers;

import com.ayiGroup.instancia1.login.Usuario;
import com.ayiGroup.instancia1.login.authenticators.AuthenticationProviderImp;
import com.ayiGroup.instancia1.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
    @Autowired
    private AuthenticationProviderImp authenticationProvider;
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticarUsuario(@RequestParam String username, @RequestParam String password, Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre(username);
        usuario.setPasswordUsuario(password);
        if (authenticationProvider.getAuthentication(usuario)) {
            return "redirect:/verificarAutenticacion";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String cerrarSesion(){
        authenticationProvider.setAuthenticate(false);

        return "login";
    }
}
