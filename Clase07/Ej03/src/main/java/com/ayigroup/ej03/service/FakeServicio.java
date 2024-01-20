package com.ayigroup.ej03.service;

import com.ayigroup.ej03.entities.Clientes;
import com.ayigroup.ej03.entities.Productos;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;

@Service
@Getter
public class FakeServicio {

    ArrayList<Productos> productos = new ArrayList<Productos>();
    LinkedList<Clientes> clientes = new LinkedList<Clientes>();

    public FakeServicio(){
        llenarProductos();
        llenarClientes();
    }

    private void llenarClientes(){
        clientes.add(new Clientes(
                1,
                "Juan Carlos",
                "Iglesias",
                "Avenida Colon 5000",
                "01142313546",
                "jciglesias5000@gmail.com"));
        clientes.add(new Clientes(
                2,
                "Mariel Alejandra",
                "Perez",
                "Avenida 9 de Julio 2555",
                "01145512536",
                "marielaperez@gmail.com"));
        clientes.add(new Clientes(
                3,
                "Agustina Vanesa",
                "Varela",
                "Avenida Rivadavia 6654",
                "01144444456",
                "avv-2023@gmail.com"));
        clientes.add(new Clientes(
                4,
                "Camila",
                "Varela",
                "Callao 310",
                "01142354899",
                "cami_varela@gmail.com"));
        clientes.add(new Clientes(
                5,
                "Facundo",
                "Diaz",
                "Avenida Córdoba 251",
                "01154545488",
                "fd-freddy@gmail.com"));
    }
    private void llenarProductos(){
        productos.add(new Productos(
                12133,
                "Ventilador Peabody",
                "Ventilador de Pie Peabody PE-VP2061",
                "PEABODY",
                46999.00f));
        productos.add(new Productos(
                54546,
                "Plancha ATMA",
                "Plancha a Vapor ATMA PAV2339PI",
                "ATMA",
                23999.00f));
        productos.add(new Productos(
                87807,
                "Pava Philips",
                "Pava Eléctrica Philips HD9368/00",
                "PHILIPS",
                35999.00f));
        productos.add(new Productos(
                90987,
                "Licuadora Smartlife",
                "Licuadora de Pie Smartlife SL-BL1008WPN",
                "SMARTLIFE",
                29399.00f));
        productos.add(new Productos(
                45451,
                "Pileta Mor",
                "Pileta de Lona Mor 1000 litros",
                "MOR",
                30399.00f));
    }

}
