package com.ayigroup.ej02.controller;

import com.ayigroup.ej02.service.PaisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BaseController {

    private PaisService paiseService;

    @GetMapping("/")
    public ModelAndView base(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("paises",paiseService.getPaises());
        return view;
    }

}
