package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Persona;
import org.example.repository.PersonaRepository;
import org.example.repository.PersonaRepositoryImp;

import java.util.List;
import java.util.UUID;

public class PersonaServiceImpl implements PersonaService{

    private static final Logger logger = LogManager.getLogger(PersonaServiceImpl.class);
    private PersonaRepository personaRepository = new PersonaRepositoryImp();

    public List<Persona> getAll(){
        logger.info("Llamado al getAll()");
        return personaRepository.getAll();
    }

    public Persona getOne(String id){
        logger.info("Llamado al getOne("+id+")");
        return personaRepository.getOne(id);
    }

    public void save(Persona persona){
        logger.info("Llamado al save("+persona.toString()+")");
        if(persona.getIdPersona()!=null){
            personaRepository.update(persona);
        }else{
            personaRepository.save(persona);
        }
    }

    public void delete(Persona persona){
        logger.info("Llamado al delete("+persona.getIdPersona()+")");
        if(persona.getIdPersona()!=null){
            personaRepository.delete(persona);
        }
    }

}
