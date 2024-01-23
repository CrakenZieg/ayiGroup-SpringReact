package com.ayigroup.ej01.services.parsers;

import com.ayigroup.ej01.persistence.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XMLParser {

    public String listOfClienteXML(List<Cliente> clientes){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml><clientes>");
        for (Cliente cliente:clientes) {
            sb.append("<cliente>");
            sb.append("<nro_cliente>"+cliente.getNroCliente()+"</nro_cliente>");
            sb.append("<nombre>"+cliente.getNombre()+"</nombre>");
            sb.append("<apellido>"+cliente.getApellido()+"</apellido>");
            sb.append("<telefono>"+cliente.getTelefono()+"</telefono>");
            sb.append("<domicilio>"+cliente.getDomicilio()+"</domicilio>");
            sb.append("</cliente>");
        }
        sb.append("</clientes></xml>");
        return sb.toString();
    }

}
