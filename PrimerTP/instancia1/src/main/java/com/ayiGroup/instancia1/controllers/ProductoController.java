package com.ayiGroup.instancia1.controllers;

import com.ayiGroup.instancia1.persistance.entities.Producto;
import com.ayiGroup.instancia1.login.authenticators.AuthenticationProviderImp;
import com.ayiGroup.instancia1.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductoController {

    @Autowired
    AuthenticationProviderImp authenticationProvider;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioAgregarProducto(Model model) {
        if(authenticationProvider.isAuthenticated()){
            return "agregarProducto";
        } else{

            model.addAttribute("error", "Debes iniciar sesión para acceder a este sitio");
            return "login";
        }

    }

    @PostMapping("/productos")
    public String agregar(Model model, Producto producto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "agregarProducto";
        }

        try {
            productoService.agregar(producto);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "agregarProducto";
        }

        return "redirect:/inicio";
    }

    @PostMapping("/productos/eliminar")
    public String eliminarProducto(@RequestParam Integer idProducto) {
        productoService.eliminar(idProducto);
        return "redirect:/inicio";
    }

}
