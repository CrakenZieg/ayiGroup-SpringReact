package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.persistence.entities.Proveedor;
import com.ayiGroup.instancia2.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String editar(Proveedor proveedor, Model model){
        model.addAttribute("proveedor", proveedorService.getOne(proveedor));
        return "proveedorForm";
    }

    @GetMapping("/eliminar/{codigoProveedor}")
    public String eliminar(Proveedor proveedor){
        proveedorService.delete(proveedorService.getOne(proveedor));
        return "redirect:/index";
    }

    @PostMapping("/guardar")
    public String save(Proveedor proveedor){
        proveedorService.save(proveedor);
        return "redirect:/index";
    }

}
