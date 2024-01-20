package com.ayigroup.ej03.controller;

import com.ayigroup.ej03.service.FakeServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BaseController {

    private FakeServicio fakeServicio;

    @GetMapping("/")
    public ModelAndView base(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("clientes",fakeServicio.getClientes());
        view.addObject("productos",fakeServicio.getProductos());
        return view;
    }

}
