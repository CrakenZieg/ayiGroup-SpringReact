package com.ayigroup.ej01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    @GetMapping("/")
    public ModelAndView base(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("titulo","El titulo es Heustonn");
        return view;
    }

}
