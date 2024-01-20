
package com.ayigroup.zieglerfrancisco.persona;

import com.ayigroup.zieglerfrancisco.documento.Documento;
import com.ayigroup.zieglerfrancisco.documento.DocumentoService;
import com.ayigroup.zieglerfrancisco.utils.Utils;

public class PersonaMenu {
    
    private Utils utils;
    private PersonaService service;
    private DocumentoService documentoService;

    public PersonaMenu(Utils utils, PersonaService service, DocumentoService documentoService) {
        this.utils = utils;
        this.service = service;
        this.documentoService = documentoService;
    }
    
    public void menuVerPersonas() {
        System.out.println("Personas:");
        service.getAll().forEach((elem) -> {
            System.out.println("Id: " + elem.getIdPersona()+ " -- " 
                    + elem.getNombre()+ " " 
                    + elem.getApellido() + " -- " 
                    + elem.getDocumento().getNumeroDocumento());
        });
        utils.separador();
    }

    public void menuAgregarPersonas() {
        try {
            service.create(new Persona(
                    0, 
                    utils.stringWhile("Ingrese el nombre:"),
                    utils.stringWhile("Ingrese el apellido:"),
                    documento()
            ));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuModificarPersonas() {
        try {
            service.update(
                    new Persona(utils.intWhile("Ingrese el id:"),
                            utils.stringWhile("Ingrese el nombre:"),
                            utils.stringWhile("Ingrese el apellido:"),
                            documento()));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuEliminarPersonas() {
        try {
            service.delete(new Persona(
                    utils.intWhile("Ingrese el id:"), 
                    "","",null));
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
    
}
