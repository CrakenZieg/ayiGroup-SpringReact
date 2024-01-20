package com.ayigroup.ej02.service;

import com.ayigroup.ej02.entity.Pais;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PaisService {

    private HashMap<String, Pais> paises = new HashMap<String,Pais>();

    public HashMap<String, Pais> getPaises(){
        paises.put("espana",new Pais("España",1));
        paises.put("inglaterra",new Pais("Inglaterra",1));
        paises.put("francia",new Pais("Francia",2));
        paises.put("uruguay",new Pais("Uruguay",2));
        paises.put("argentina",new Pais("Argentina", 2));
        paises.put("italia",new Pais("Italia",4));
        paises.put("alemania",new Pais("Alemania", 4));
        paises.put("brasil",new Pais("Brasil",5));
        return this.paises;
    }

}
