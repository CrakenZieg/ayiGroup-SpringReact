package org.example.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.persistence.entity.Empleado;
import org.example.service.EmpleadoService;
import org.example.service.EmpleadoServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {

    private static final Logger logger = LogManager.getLogger(Menu.class);
    private EmpleadoService empleadoService = new EmpleadoServiceImpl();
    private BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));

    public void menu(){
        int option = 10;
        do{
            separador();
            System.out.println("1. Ver lista\n" +
                    "2. Agregar\n" +
                    "3. Modificar\n" +
                    "4. Eliminar\n" +
                    "5. Salir");
            try{
                option = Integer.parseInt(rdr.readLine());
            } catch (IOException ex){
                logger.error("Error: "+ex);
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
        List<Empleado> Empleados = empleadoService.getAll();
        if(Empleados!=null) {
            Empleados.forEach((persona) -> {
                System.out.println(persona.toString());
            });
        } else {
            System.out.println("Lista vacía");
        }
    }

    public void create(){
        separador();
        Empleado Empleado = new Empleado();
        empleadoService.save(completarEmpleado(Empleado));
    }

    public void update(){
        separador();
        Empleado Empleado = null;
        String id = null;
        try {
            System.out.println("Introduce el id:");
            id = rdr.readLine();
        } catch (IOException ex){
            logger.error("Error: "+ex);
            id = null;
        }
        if(id!=null){
            logger.info("Buscando id: "+id);
            Empleado = empleadoService.getOne(id);
            if(Empleado == null){
                System.out.println("Empleado no encontrado");
                return;
            }
        }
        logger.info("Empleado a modificar: "+ Empleado.toString());
        empleadoService.save(completarEmpleado(Empleado));
    }

    public void delete(){
        separador();
        Empleado Empleado = null;
        String id = null;
        try {
            System.out.println("Introduce el id:");
            id = rdr.readLine();
        } catch (IOException ex){
            logger.error("Error: "+ex);
            id = null;
        }
        if(id!=null) {
            logger.info("Buscando id: "+id);
            Empleado = empleadoService.getOne(id);
            if(Empleado == null){
                System.out.println("Empleado no encontrado");
                return;
            }
        }
        logger.info("Empleado a eliminar: "+ Empleado.toString());
        empleadoService.delete(Empleado);
    }

    private void separador(){
        System.out.println("<--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*-->");
    }

    private Empleado completarEmpleado(Empleado Empleado){
        do{
            System.out.println("Introduce el nombre del empleado: ");
            try {
                Empleado.setNombre(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(Empleado.getNombre()==null);
        do{
            System.out.println("Introduce el apellido del empleado: ");
            try {
                Empleado.setApellido(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(Empleado.getApellido()==null);
        do{
            System.out.println("Introduce el telefono del empleado: ");
            try {
                Empleado.setTelefono(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(Empleado.getTelefono()==null);
        do{
            System.out.println("Introduce el domicilio del empleado: ");
            try {
                Empleado.setDomicilio(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(Empleado.getDomicilio()==null);
        return Empleado;
    }

}
