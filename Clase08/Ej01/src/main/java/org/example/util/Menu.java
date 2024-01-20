package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Persona;
import org.example.service.PersonaService;
import org.example.service.PersonaServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Logger logger = LogManager.getLogger(Menu.class);
    private PersonaService personaService = new PersonaServiceImpl();
    private Scanner scn = new Scanner(System.in);

    public void menu(){
        int option = 10;
        do{
            System.out.println("1. Ver lista\n" +
                    "2. Agregar\n" +
                    "3. Modificar\n" +
                    "4. Eliminar\n" +
                    "5. Salir");
            try{
                option = scn.nextInt();
            } catch (InputMismatchException ex){
                logger.error(ex);
            }
            switch (option){
                case 1->showAll();
                case 2->create();
                case 3->update();
                case 4->delete();
                case 5->{
                    separador();
                    System.out.println("Gracias por usar nuestros servicios, hasta luego!");
                    separador();
                    option = 0;
                }
            }
        }while(option!=0);
    }

    public void showAll(){
        separador();
        System.out.println("Personas en lista: ");
        List<Persona> personas = personaService.getAll();
        if(personas!=null) {
            personas.forEach((persona)->{
                System.out.println(persona.toString());
            });
        } else {
            System.out.println("Lista vacía");
        }
    }

    public void create(){
        separador();
        Persona persona = new Persona();
        do{
            System.out.println("Introduce el nombre de la persona: ");
            persona.setNombre(scn.next());
        }while(persona.getNombre()==null);
        do{
            System.out.println("Introduce el apellido de la persona: ");
            persona.setApellido(scn.next());
        }while(persona.getApellido()==null);
        personaService.save(persona);
    }

    public void update(){
        separador();
        Persona persona = null;
        String uuid = null;
        System.out.println("Introduce el id:");
        uuid = scn.next();
        if(!uuid.isBlank()){
            logger.info("Buscando uuid: "+uuid);
            persona = personaService.getOne(uuid);
            if(persona!=null){
                System.out.println(persona.toString());
            }
        }
        logger.info("Persona a modificar: "+persona.toString());
        do{
            System.out.println("Introduce el nombre de la persona: ");
            persona.setNombre(scn.next());
        }while(persona.getNombre()==null);
        do{
            System.out.println("Introduce el apellido de la persona: ");
            persona.setApellido(scn.next());
        }while(persona.getApellido()==null);
        personaService.save(persona);
    }

    public void delete(){
        separador();
        Persona persona = null;
        String uuid = null;
        System.out.println("Introduce el id:");
        uuid = scn.next();
        if(!uuid.isBlank()){
            logger.info("Buscando uuid: "+uuid);
            persona = personaService.getOne(uuid);
            if(persona!=null){
                System.out.println(persona.toString());
            }
        }
        personaService.delete(persona);
    }

    private void separador(){
        System.out.println("<--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*-->");
    }

}
