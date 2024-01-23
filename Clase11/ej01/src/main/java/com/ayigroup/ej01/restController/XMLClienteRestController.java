package com.ayigroup.ej01.restController;

import com.ayigroup.ej01.persistence.entities.Cliente;
import com.ayigroup.ej01.services.ClienteService;
import com.ayigroup.ej01.services.parsers.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/xml")
public class XMLClienteRestController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private XMLParser xmlParser;

    @GetMapping(value="/clientes-list", produces = MediaType.TEXT_XML_VALUE)
    public String getAllListXML(){
        return xmlParser.listOfClienteXML(clienteService.getAll());
    }

    @GetMapping(value="/cliente/{nro}", produces = MediaType.TEXT_XML_VALUE)
    public String getOneXML(@PathVariable int nro){
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(clienteService.getOne(nro));
        return xmlParser.listOfClienteXML(clientes);
    }
}
