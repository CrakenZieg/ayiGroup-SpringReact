package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.login.authentication.AuthenticationProvider;
import com.ayiGroup.instancia2.persistence.entities.Proveedor;
import com.ayiGroup.instancia2.login.Usuario;
import com.ayiGroup.instancia2.services.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String home(Model model){
        if(authenticationProvider.isAuthenticated()){
            return "redirect:/index";
        } else {
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "redirect:/";
    }

    @PostMapping("/login")
    public String logedIn(@Valid Usuario usuario, Model model){
        if(!authenticationProvider.getAuthentication(usuario)) {
            model.addAttribute("error", "Credenciales incorrectas");
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
        if(!authenticationProvider.isAuthenticated()){
            return "redirect:/login";
        }
        List<Proveedor> proveedores = proveedorService.getAll();
        model.addAttribute("tittle", tittle);
        model.addAttribute("proveedores", proveedores);
        return "index";
    }

}
