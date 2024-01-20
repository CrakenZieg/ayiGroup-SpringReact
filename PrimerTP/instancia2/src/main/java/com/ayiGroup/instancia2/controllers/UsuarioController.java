package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.persistence.entities.Usuario;
import com.ayiGroup.instancia2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/agregar")
    public String agregar(Model model){
        model.addAttribute("proveedor",new Usuario());
        return "usuarioForm";
    }

    @GetMapping("/editar/{codigoProveedor}")
    public String editar(@RequestParam int idUsuario, Model model){
        model.addAttribute("proveedor", usuarioService.getOne(idUsuario));
        return "usuarioForm";
    }

    @GetMapping("/eliminar/{codigoProveedor}")
    public String eliminar(@RequestParam int idUsuario){
        usuarioService.delete(usuarioService.getOne(idUsuario));
        return "redirect:/index";
    }

}
