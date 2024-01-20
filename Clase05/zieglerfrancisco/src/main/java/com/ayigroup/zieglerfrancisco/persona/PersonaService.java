
package com.ayigroup.zieglerfrancisco.persona;

import java.util.List;

public class PersonaService {
    
    private PersonaDao personaDao;  

    public PersonaService(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public List<Persona> getAll() {        
        return personaDao.getAll();
    }

    public Persona getOne(int id) throws Exception {   
        validateNumber(id);
        return personaDao.getOne(id);
    }

    public Persona create(Persona newEntity) throws Exception {
        validadatePerson(newEntity);
        return personaDao.create(newEntity);
    }
    
    public Persona update(Persona upEntity) throws Exception {  
        validateNumber(upEntity.getIdPersona());
        validadatePerson(upEntity);
        return personaDao.update(upEntity);
    }

    public Persona delete(Persona delEntity) throws Exception { 
        validateNumber(delEntity.getIdPersona());
        return personaDao.delete(delEntity);
    }
    
    private void validateNumber(int num) throws Exception{
        if(num==0){
            throw new Exception("El numero de id no puede ser cero");
        }
    }
    
    private void validadatePerson(Persona entity) throws Exception{        
        if(entity.getNombre().isBlank()){
            throw new Exception("El nombre no puede estar vacío");
        }
        if(entity.getApellido().isBlank()){
            throw new Exception("El apellido no puede estar vacío");
        }
        if(entity.getDocumento()==null||entity.getDocumento().getDescripcion().isBlank()){
            throw new Exception("El documento no puede estar vacío");
        }
    }
    
}
