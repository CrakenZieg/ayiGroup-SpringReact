package com.ayigroup.zieglerfrancisco.tipoUsuario;

import com.ayigroup.zieglerfrancisco.utils.Utils;

public class TipoUsuarioMenu {

    private Utils utils;
    private TipoUsuarioService service;

    public TipoUsuarioMenu(Utils utils, TipoUsuarioService service) {
        this.utils = utils;
        this.service = service;
    }

    public void menuVerTipos() {
        System.out.println("Tipos de usuario disponibles:");
        service.getAll().forEach((elem) -> {
            System.out.println("Id: " + elem.getIdTipoUsuario() + " -- " + elem.getDescripcion());
        });
        utils.separador();
    }

    public void menuAgregarTipos() {
        try {
            service.create(new TipoUsuario(0, utils.stringWhile("Ingrese la descripción:")));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuModificarTipos() {
        try {
            service.update(
                    new TipoUsuario(utils.intWhile("Ingrese el id:"),
                            utils.stringWhile("Ingrese la descripción:")));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

    public void menuEliminarTipos() {
        try {
            service.delete(new TipoUsuario(utils.intWhile("Ingrese el id:"), ""));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        utils.separador();
    }

}
