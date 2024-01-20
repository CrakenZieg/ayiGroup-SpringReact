package com.ayiGroup.instancia2.controllers;

import com.ayiGroup.instancia2.persistence.entities.Proveedor;
import com.ayiGroup.instancia2.services.ProveedorService;
import jakarta.validation.Valid;
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

    @GetMapping("/add")
    public String agregar(Model model){
        model.addAttribute("proveedor",new Proveedor());
        return "proveedorForm";
    }

    @GetMapping("/edit/{idProveedor}")
    public String editar(Proveedor proveedor, Model model){
        proveedor = proveedorService.getOne(proveedor);
        model.addAttribute("proveedor", proveedor);
        return "proveedorForm";
    }

    @GetMapping("/delete/{idProveedor}")
    public String eliminar(Proveedor proveedor){
        proveedor = proveedorService.getOne(proveedor);
        proveedorService.delete(proveedorService.getOne(proveedor));
        return "redirect:/index";
    }

    @PostMapping("/save")
    public String save(@Valid Proveedor proveedor, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("errorNombre", errors.getFieldError("nombre").getDefaultMessage());
            model.addAttribute("errorTelefono", errors.getFieldError("telefono").getDefaultMessage());
            model.addAttribute("errorDireccion", errors.getFieldError("direccion").getDefaultMessage());
            model.addAttribute("errorEmail", errors.getFieldError("email").getDefaultMessage());
            model.addAttribute("errorWeb", errors.getFieldError("web").getDefaultMessage());
            return "proveedorForm";
        }
        proveedorService.save(proveedor);
        return "redirect:/index";
    }

}
