package com.ayigroup.ej01.services.parsers;

import com.ayigroup.ej01.persistence.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HTMLParser {

    public String listToHtmlTable(List<Cliente> clientes) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<td>Numero de Cliente</td>");
        sb.append("<td>Nombre</td>");
        sb.append("<td>Apellido</td>");
        sb.append("<td>Telefono</td>");
        sb.append("<td>Domicilio</td>");
        sb.append("</tr>");
        sb.append("</thead>");
        sb.append("<tbody>");
        for (Cliente cliente:clientes) {
            sb.append("<tr>");
            sb.append("<td>"+cliente.getNroCliente()+"</td>");
            sb.append("<td>"+cliente.getNombre()+"</td>");
            sb.append("<td>"+cliente.getApellido()+"</td>");
            sb.append("<td>"+cliente.getTelefono()+"</td>");
            sb.append("<td>"+cliente.getDomicilio()+"</td>");
            sb.append("</tr>");
        }
        sb.append("<tbody>");
        sb.append("</table>");
        return sb.toString();
    }

    public String listToHtmlList(List<Cliente> clientes) {
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (Cliente cliente:clientes) {
            sb.append("<li>"+cliente.getNroCliente()+": ");
            sb.append(cliente.getApellido()+", ");
            sb.append(cliente.getNombre()+"; ");
            sb.append("telefono: "+cliente.getApellido()+", ");
            sb.append("domicilio: "+cliente.getApellido()+"</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    public String listToHtmlP(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>"+cliente.getNroCliente()+": ");
        sb.append(cliente.getApellido()+", ");
        sb.append(cliente.getNombre()+"; ");
        sb.append("telefono: "+cliente.getApellido()+", ");
        sb.append("domicilio: "+cliente.getApellido()+"</p>");
        return sb.toString();
    }

    public String htmlElementWrapper(String title, String body){
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>");
        sb.append(title);
        sb.append("</title></head><body>");
        sb.append(body);
        sb.append("</body></html>");
        return sb.toString();
    }

}
