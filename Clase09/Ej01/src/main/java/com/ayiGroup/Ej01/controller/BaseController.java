package com.ayiGroup.Ej01.controller;

import com.ayiGroup.Ej01.entity.Usuario2;
import com.ayiGroup.Ej01.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Value("${titulo}")
    private String titulo;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ModelAndView base(ModelMap model){
        logger.info("Request a url base!");
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios = usuarioService.getAll();
        model.addAttribute("usuarios",usuarios);
        model.addAttribute("titulo",titulo);
        return new ModelAndView("index", model);
    }

}
