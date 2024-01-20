
package com.ayigroup.zieglerfrancisco.documento;

import com.ayigroup.zieglerfrancisco.utils.Utils;

public class DocumentoMenu {
    
    private Utils utils;
    private DocumentoService service;

    public DocumentoMenu(Utils utils, DocumentoService service) {
        this.utils = utils;
        this.service = service;
    }
    
    public void menuVerDocumentos() {
        System.out.println("Documentos:");
        service.getAll().forEach((elem) -> {
            System.out.println("Tipo: " + elem.getNumeroDocumento()+ " -- Numero: " + elem.getDescripcion());
        });
        utils.separador();
    }

    public void menuAgregarDocumentos() {
        try {
            service.create(new Documento(
                    utils.intWhile("Ingrese el numero de documento: "), 
                    utils.stringWhile("Ingrese la descripción:")));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuModificarDocumentos() {
        try {
            service.update(new Documento(
                    utils.intWhile("Ingrese el numero de documento: "), 
                    utils.stringWhile("Ingrese la descripción:")));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuEliminarDocumentos() {
        try {
            service.delete(new Documento(utils.intWhile("Ingrese el numero de documento: "), ""));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

}