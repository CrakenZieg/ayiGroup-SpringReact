package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.repositories.entities.Proveedor;
import com.ayiGroup.instancia2.repositories.entities.Usuario;
import com.ayiGroup.instancia2.services.ProveedorService;
import com.ayiGroup.instancia2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private UsuarioService usuarioService;

    @Value("${titulo}")
    private String titulo;

    @GetMapping("/")
    public String base(Model model){
        List<Proveedor> proveedores = proveedorService.getAll();
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("titulo", titulo);
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

}
