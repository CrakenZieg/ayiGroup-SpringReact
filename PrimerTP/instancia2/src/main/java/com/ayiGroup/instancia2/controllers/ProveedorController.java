package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.persistence.entities.Proveedor;
import com.ayiGroup.instancia2.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/agregar")
    public String agregar(Model model){
        model.addAttribute("proveedor",new Proveedor());
        return "proveedorForm";
    }

    @GetMapping("/editar/{codigoProveedor}")
    public String editar(@RequestParam int codigoProveedor, Model model){
        model.addAttribute("proveedor", proveedorService.getOne(codigoProveedor));
        return "proveedorForm";
    }

    @GetMapping("/eliminar/{codigoProveedor}")
    public String eliminar(@RequestParam int codigoProveedor){
        proveedorService.delete(proveedorService.getOne(codigoProveedor));
        return "redirect:/index";
    }

}
