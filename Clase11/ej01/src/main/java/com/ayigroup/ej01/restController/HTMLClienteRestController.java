package com.ayigroup.ej01.restController;

import com.ayigroup.ej01.services.ClienteService;
import com.ayigroup.ej01.services.parsers.HTMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/html")
public class HTMLClienteRestController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private HTMLParser htmlParser;

    @GetMapping(value="/clientes-list", produces = MediaType.TEXT_HTML_VALUE)
    public String getAllListHTML(){
        return htmlParser.htmlElementWrapper(
                "Lista",
                htmlParser.listToHtmlList(clienteService.getAll()));
    }

    @GetMapping(value="/clientes-table", produces = MediaType.TEXT_HTML_VALUE)
    public String getAllTableHTML(){
        return htmlParser.htmlElementWrapper(
                "Tabla",
                htmlParser.listToHtmlTable(clienteService.getAll()));
    }

    @GetMapping(value="/cliente/{nro}", produces = MediaType.TEXT_HTML_VALUE)
    public String getOneHTML(@PathVariable int nro){
        return htmlParser.htmlElementWrapper(
                "Cliente",
                htmlParser.listToHtmlP(clienteService.getOne(nro)));
    }

}
