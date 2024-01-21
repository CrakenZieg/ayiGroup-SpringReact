package com.ayiGroup.instancia1.controllers;
import com.ayiGroup.instancia1.persistance.entities.Producto;
import com.ayiGroup.instancia1.persistance.entities.Servicio;
import com.ayiGroup.instancia1.login.authenticators.AuthenticationProviderImp;
import com.ayiGroup.instancia1.services.ProductoService;
import com.ayiGroup.instancia1.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private AuthenticationProviderImp authenticationProvider;
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ServicioService servicioService;

    @Value("${tituloProductos}")
    private String tituloProductos;

    @Value("${tituloServicios}")
    private String tituloServicios;

    @GetMapping("/inicio")
    public String mostrarTitulosYListasProductosYServicios(Model model) {

        if (!authenticationProvider.isAuthenticated()){
            model.addAttribute("error", "Debes iniciar sesión para ingresar a este sitio.");
            return "login";
        }

        List<Producto> productos = productoService.listar();
        List<Servicio> servicios = servicioService.listar();

        model.addAttribute("productos", productos);
        model.addAttribute("servicios", servicios);
        model.addAttribute("tituloProductos", tituloProductos);
        model.addAttribute("tituloServicios", tituloServicios);

        return "index";
    }

    @GetMapping("/")
    public String redirigirALogin() {

        return "redirect:/verificarAutenticacion";
    }

    @GetMapping("/verificarAutenticacion")
    public String verificarAutenticacion(Model model) {
        boolean isAuthenticated = authenticationProvider.isAuthenticated();

        if(isAuthenticated){
            return "redirect:/inicio";
        } else{
            model.addAttribute("error", "Debes iniciar sesión para acceder a este sitio");
            return "redirect:/login";
        }
    }

}
