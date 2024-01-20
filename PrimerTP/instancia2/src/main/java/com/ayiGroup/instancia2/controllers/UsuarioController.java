package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.persistence.entities.Usuario;
import com.ayiGroup.instancia2.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/agregar")
    public String agregar(Model model){
        model.addAttribute("usuario",new Usuario());
        return "usuarioForm";
    }

    @GetMapping("/editar/{idUsuario}")
    public String editar(Usuario usuario, Model model){
        model.addAttribute("usuario", usuarioService.getOne(usuario));
        return "usuarioForm";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String eliminar(Usuario usuario){
        usuarioService.delete(usuarioService.getOne(usuario));
        return "redirect:/index";
    }

    @PostMapping("/guardar")
    public String save(@Valid Usuario usuario, Errors errors){
        if(errors.hasErrors()){
            return "usuarioForm";
        }
        usuarioService.save(usuario);
        return "redirect:/index";
    }

}
