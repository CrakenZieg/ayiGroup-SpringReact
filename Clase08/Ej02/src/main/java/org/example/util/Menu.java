package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Clientes;
import org.example.service.ClientesService;
import org.example.service.ClientesServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {

    private static final Logger logger = LogManager.getLogger(Menu.class);
    private ClientesService clientesService = new ClientesServiceImpl();
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
        System.out.println("Clientes en lista: ");
        List<Clientes> clientes = clientesService.getAll();
        if(clientes!=null) {
            clientes.forEach((persona) -> {
                System.out.println(persona.toString());
            });
        } else {
            System.out.println("Lista vacía");
        }
    }

    public void create(){
        separador();
        Clientes cliente = new Clientes();
        clientesService.save(completarCliente(cliente));
    }

    public void update(){
        separador();
        Clientes cliente = null;
        int id = 0;
        try {
            System.out.println("Introduce el id:");
            id = Integer.parseInt(rdr.readLine());
        } catch (IOException ex){
            logger.error("Error: "+ex);
            id = 0;
        }
        if(id!=0){
            logger.info("Buscando id: "+id);
            cliente = clientesService.getOne(id);
            if(cliente == null){
                System.out.println("Cliente no encontrado");
                return;
            }
        }
        logger.info("Cliente a modificar: "+ cliente.toString());
        clientesService.save(completarCliente(cliente));
    }

    public void delete(){
        separador();
        Clientes cliente = null;
        int id = 0;
        try {
            System.out.println("Introduce el id:");
            id = Integer.parseInt(rdr.readLine());
        } catch (IOException ex){
            logger.error("Error: "+ex);
            id = 0;
        }
        if(id!=0) {
            logger.info("Buscando id: "+id);
            cliente = clientesService.getOne(id);
            if(cliente == null){
                System.out.println("Cliente no encontrado");
                return;
            }
        }
        logger.info("Cliente a eliminar: "+ cliente.toString());
        clientesService.delete(cliente);
    }

    private void separador(){
        System.out.println("<--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*-->");
    }

    private Clientes completarCliente(Clientes cliente){
        do{
            System.out.println("Introduce el nombre del cliente: ");
            try {
                cliente.setNombre(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(cliente.getNombre()==null);
        do{
            System.out.println("Introduce el apellido del cliente: ");
            try {
                cliente.setApellido(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(cliente.getApellido()==null);
        do{
            System.out.println("Introduce el telefono del cliente: ");
            try {
                cliente.setTelefono(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(cliente.getTelefono()==null);
        do{
            System.out.println("Introduce el domicilio del cliente: ");
            try {
                cliente.setDomicilio(rdr.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(cliente.getDomicilio()==null);
        return cliente;
    }

}
