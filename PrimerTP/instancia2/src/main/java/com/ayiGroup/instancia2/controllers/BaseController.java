package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.authentication.AuthenticationProvider;
import com.ayiGroup.instancia2.repositories.entities.Proveedor;
import com.ayiGroup.instancia2.repositories.entities.Usuario;
import com.ayiGroup.instancia2.services.ProveedorService;
import com.ayiGroup.instancia2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BaseController {

    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Value("${titulo}")
    private String titulo;

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String logedIn(Usuario usuario, Model model){
        if(authenticationProvider.getAuthentication(usuario)){
            return "redirect:/index";
        } else {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Proveedor> proveedores = proveedorService.getAll();
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("titulo", titulo);
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("autenticado", authenticationProvider.isAuthenticated());
        return "index";
    }

}
