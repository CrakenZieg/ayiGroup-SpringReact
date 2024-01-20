package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.authentication.AuthenticationProvider;
import com.ayiGroup.instancia2.persistence.entities.Proveedor;
import com.ayiGroup.instancia2.persistence.entities.Usuario;
import com.ayiGroup.instancia2.services.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class BaseController {

    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Value("${tittle}")
    private String tittle;

    @GetMapping("/")
    public String login(Model model){
        if(authenticationProvider.isAuthenticated()){
            return "redirect:/index";
        } else {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
    }

    @PostMapping("/login")
    public String logedIn(@Valid Usuario usuario, Model model, Errors errors){
        if(!authenticationProvider.getAuthentication(usuario)) {
            model.addAttribute("error", "Credenciales incorrectas");
            if (errors.hasErrors()) {
                model.addAttribute("errorNombre", errors.getFieldError("nombre").getDefaultMessage());
                model.addAttribute("errorPassword", errors.getFieldError("password").getDefaultMessage());
            }
            return "login";
        }
        return "redirect:index";
    }

    @GetMapping("/logout")
    public String logout(){
        authenticationProvider.setAuthenticate(false);
        return "redirect:/";
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Proveedor> proveedores = proveedorService.getAll();
        model.addAttribute("tittle", tittle);
        model.addAttribute("proveedores", proveedores);
        return "index";
    }

}
