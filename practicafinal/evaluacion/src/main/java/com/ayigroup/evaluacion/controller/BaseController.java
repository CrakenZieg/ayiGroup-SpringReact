package com.ayigroup.evaluacion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1")
public class BaseController {

    @GetMapping("/")
    public String base(){
        return "base";
    }



}