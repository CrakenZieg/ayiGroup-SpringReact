package com.ayiGroup.instancia1.controllers;

import com.ayiGroup.instancia1.persistance.entities.Servicio;
import com.ayiGroup.instancia1.login.authenticators.AuthenticationProviderImp;
import com.ayiGroup.instancia1.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServicioController {

    @Autowired
    private AuthenticationProviderImp authenticationProvider;
    @Autowired
    private ServicioService servicioService;

    @GetMapping("/servicios/nuevo")
    public String mostrarFormularioAgregarServicio(Model model){

        if(authenticationProvider.isAuthenticated()){
            return "agregarServicio";
        } else{

            model.addAttribute("error", "Debes iniciar sesión para acceder a este sitio");
            return "login";
        }


    }

    @PostMapping("/servicios")
    public String agregar(Model model, Servicio servicio, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "agregarServicio";
        }

        try {
            servicioService.agregar(servicio);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "agregarServicio";
        }

        return "redirect:/inicio";
    }

    @PostMapping("/servicios/eliminar")
    public String eliminarServicio(@RequestParam Integer idServicio) {
        servicioService.eliminar(idServicio);
        return "redirect:/inicio";
    }
}
