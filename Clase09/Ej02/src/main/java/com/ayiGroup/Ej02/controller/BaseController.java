package com.ayiGroup.Ej02.controller;

import com.ayiGroup.Ej02.persistence.entity.Empleado;
import com.ayiGroup.Ej02.persistence.entity.Sucursal;
import com.ayiGroup.Ej02.service.EmpleadoService;
import com.ayiGroup.Ej02.service.EmpleadoServiceImp;
import com.ayiGroup.Ej02.service.SucursalService;
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

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SucursalService sucursalService;

    @Value("${titulo}")
    private String titulo;

    @GetMapping("/")
    public ModelAndView base(ModelMap model){
        logger.info("Request a url base!");

        List<Empleado> empleados = new ArrayList<>();
        empleados = empleadoService.getAll();
        model.addAttribute("empleados",empleados);

        List<Sucursal> sucursales = new ArrayList<>();
        sucursales = sucursalService.getAll();
        model.addAttribute("sucursales",sucursales);

        model.addAttribute("titulo",titulo);

        return new ModelAndView("index",model);
    }

}
