package com.ayigroup.zieglerfrancisco.ui;

import com.ayigroup.zieglerfrancisco.utils.Initializer;

public class Menu {

    private Initializer init;
    int option = 0;

    public Menu() {
        init = new Initializer();       
    }

    public void menu() {
        do {
            option = init.getUtils().intWhile("Ingresa un opcion:\n"
                    + "1. Usuarios\n"
                    + "2. Personas\n"
                    + "3. Documentos\n"
                    + "4. Tipos de usuarios\n"
                    + "5. Salir");
            switch (option) {
                case 1 -> {
                    menuUsuarios();
                }
                case 2 -> {
                    menuPersonas();
                }
                case 3 -> {
                    menuDocumentos();
                }
                case 4 -> {
                    menuTipos();
                }
                case 5 -> {
                    menuSalir();
                }
            }
        } while (option != -1);
    }

    public void menuUsuarios() {
        do {
            option = init.getUtils().intWhile("Ingresa un opcion:\n"
                    + "1. Ver usuarios\n"
                    + "2. Agregar usuarios\n"
                    + "3. Modificar usuarios\n"
                    + "4. Eliminar usuarios\n"
                    + "5. Volver");
            switch (option) {
                case 1 -> {
                    init.getUsuarioMenu().menuVerUsuarios();
                }
                case 2 -> {
                    init.getUsuarioMenu().menuAgregarUsuarios();
                }
                case 3 -> {
                    init.getUsuarioMenu().menuModificarUsuarios();
                }
                case 4 -> {
                    init.getUsuarioMenu().menuEliminarUsuarios();
                }
                case 5 -> {
                    option = -4;
                }
            }
        } while (option != -4);
    }

    public void menuPersonas() {
        do {
            option = init.getUtils().intWhile("Ingresa un opcion:\n"
                    + "1. Ver personas\n"
                    + "2. Agregar personas\n"
                    + "3. Modificar personas\n"
                    + "4. Eliminar personas\n"
                    + "5. Volver");
            switch (option) {
                case 1 -> {
                    init.getPersonaMenu().menuVerPersonas();
                }
                case 2 -> {
                    init.getPersonaMenu().menuAgregarPersonas();
                }
                case 3 -> {
                    init.getPersonaMenu().menuModificarPersonas();
                }
                case 4 -> {
                    init.getPersonaMenu().menuEliminarPersonas();
                }
                case 5 -> {
                    option = -4;
                }
            }
        } while (option != -4);
    }

    public void menuDocumentos() {
        do {
            option = init.getUtils().intWhile("Ingresa un opcion:\n"
                    + "1. Ver documentos\n"
                    + "2. Agregar documentos\n"
                    + "3. Modificar documentos\n"
                    + "4. Eliminar documentos\n"
                    + "5. Volver");
            switch (option) {
                case 1 -> {
                    init.getDocumentoMenu().menuVerDocumentos();
                }
                case 2 -> {
                    init.getDocumentoMenu().menuAgregarDocumentos();
                }
                case 3 -> {
                    init.getDocumentoMenu().menuModificarDocumentos();
                }
                case 4 -> {
                    init.getDocumentoMenu().menuEliminarDocumentos();
                }
                case 5 -> {
                    option = -4;
                }
            }
        } while (option != -4);
    }

    public void menuTipos() {
        do {
            option = init.getUtils().intWhile("Ingresa un opcion:\n"
                    + "1. Ver tipos de usuario\n"
                    + "2. Agregar tipo de usuario\n"
                    + "3. Modificar tipo de usuario\n"
                    + "4. Eliminar tipo de usuario\n"
                    + "5. Volver");
            switch (option) {
                case 1 -> {
                    init.getTipoUsuarioMenu().menuVerTipos();
                }
                case 2 -> {
                    init.getTipoUsuarioMenu().menuAgregarTipos();
                }
                case 3 -> {
                    init.getTipoUsuarioMenu().menuModificarTipos();
                }
                case 4 -> {
                    init.getTipoUsuarioMenu().menuEliminarTipos();
                }
                case 5 -> {
                    option = -4;
                }
            }
        } while (option != -4);
    }

    public void menuSalir() {
        String opt = init.getUtils().stringWhile("Está seguro que desea salir? (y/n)");
        if (opt.toLowerCase().equals("y")) {
            option = -1;
        }
    }

}
