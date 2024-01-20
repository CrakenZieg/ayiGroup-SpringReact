
package com.ayigroup.zieglerfrancisco.usuario;

import com.ayigroup.zieglerfrancisco.documento.Documento;
import com.ayigroup.zieglerfrancisco.documento.DocumentoService;
import com.ayigroup.zieglerfrancisco.persona.Persona;
import com.ayigroup.zieglerfrancisco.persona.PersonaService;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuario;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuarioService;
import com.ayigroup.zieglerfrancisco.utils.Utils;

public class UsuarioMenu {
     
    private Utils utils;
    private UsuarioService service;    
    private PersonaService personaService;
    private DocumentoService documentoService;
    private TipoUsuarioService tipoUsuarioService;

    public UsuarioMenu(Utils utils, 
            UsuarioService service, 
            PersonaService personaService, 
            DocumentoService documentoService,
            TipoUsuarioService tipoUsuarioService) {
        this.utils = utils;
        this.service = service;
        this.personaService = personaService;        
        this.documentoService = documentoService;
        this.tipoUsuarioService = tipoUsuarioService;
    }
    
    public void menuVerUsuarios() {
        System.out.println("Usuarios:");
        service.getAll().forEach((elem) -> {
            System.out.println("Id: " + elem.getIdUsuario()+ " -- " 
                    + elem.getNombreUsuario()+ " -- " 
                    + elem.getTipoUsuario());
        });
        utils.separador();
    }

    public void menuAgregarUsuarios() {
        try {
            service.create(new Usuario(
                    0, 
                    utils.stringWhile("Ingrese el nombre de usuario:"),
                    utils.stringWhile("Ingrese el password:"),
                    persona(),
                    tipoUsuario()
            ));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuModificarUsuarios() {
        try {
            service.update(new Usuario(
                    utils.intWhile("Ingrese el id:"),
                    utils.stringWhile("Ingrese el nombre de usuario:"),
                    utils.stringWhile("Ingrese el password:"),
                    persona(),
                    tipoUsuario()
            ));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuEliminarUsuarios() {
        try {
            service.delete(new Usuario(
                    utils.intWhile("Ingrese el id:"), 
                    "","",null,null));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }
    
    private Documento documento(){
        Documento documento = null;
        if(utils.stringWhile("Utilizar documento existente? (y/n)")
                .toLowerCase().equals("y")){
            documentoService.getAll().stream().forEach((elem)->{
                System.out.println(elem.getNumeroDocumento());
            });
            try{
                documento = documentoService.getOne(utils.intWhile("Introduzca el documento: "));
            } catch(Exception ex){
                System.out.println("Error: "+ex);
            }
        } else {
            try{
                documento = documentoService.create(new Documento(
                    utils.intWhile("Introduzca el numero de documento: "),
                    utils.stringWhile("Introduzca la descripcion: ")));
            } catch(Exception ex){
                System.out.println("Error: "+ex);
            }
        }
        return documento;
    }
    
    private Persona persona(){
        Persona persona = null;
        if(utils.stringWhile("Utilizar una persona existente? (y/n)")
                .toLowerCase().equals("y")){
            personaService.getAll().forEach((elem) -> {
                System.out.println("Id: " + elem.getIdPersona()+ " -- " 
                    + elem.getNombre()+ " " 
                    + elem.getApellido() + " -- " 
                    + elem.getDocumento().getNumeroDocumento());
                });            
            try{
                persona = personaService.getOne(utils.intWhile("Introduzca el id: "));
            } catch(Exception ex){
                System.out.println("Error: "+ex);
            }
        } else {
            try{
                persona = personaService.create(new Persona(
                        0,
                        utils.stringWhile("Introduzca el nombre: "),
                        utils.stringWhile("Introduzca el apellido: "),
                        documento()));
            } catch(Exception ex){
                System.out.println("Error: "+ex);
            }
        }
        return persona;
    }
    
    private TipoUsuario tipoUsuario(){
        TipoUsuario tipo = null;
        if(utils.stringWhile("Utilizar una tipo de usuario existente? (y/n)")
                .toLowerCase().equals("y")){
            tipoUsuarioService.getAll().forEach((elem) -> {
                System.out.println("Id: " + elem.getIdTipoUsuario()+ " -- " 
                    + elem.getDescripcion());
                });            
            try{
                tipo = tipoUsuarioService.getOne(utils.intWhile("Introduzca el id: "));
            } catch(Exception ex){
                System.out.println("Error: "+ex);
            }
        } else {
            try{
                tipo = tipoUsuarioService.create(new TipoUsuario(                        
                        0,
                        utils.stringWhile("Introduzca la descripción: ")
                ));
            } catch(Exception ex){
                System.out.println("Error: "+ex);
            }
        }
        return tipo;
    }
    
}
