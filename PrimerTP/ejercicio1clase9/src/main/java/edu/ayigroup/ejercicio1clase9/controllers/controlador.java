package edu.ayigroup.ejercicio1clase9.controllers;

//import org.springframework.web.bind.annotation.RestController;
import edu.ayigroup.ejercicio1clase9.services.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController  -> Esto para el ultimo punto que pide validar con Postman
@Controller
public class controlador {

    @Autowired
    private ServicioUsuarios usuarioDao;

    @Value("${titulo}")
    private String titulo;

    @GetMapping("/paginausuarios")
    public String getDatos(Model model) {
        var usuarios = usuarioDao.getUsuarios();
        model.addAttribute("titulo", titulo);
        model.addAttribute("usuarios", usuarios);
        return "paginausuarios";
    }

}
