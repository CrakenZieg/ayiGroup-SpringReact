
package com.ayigroup.zieglerfrancisco.persona;

import com.ayigroup.zieglerfrancisco.persona.Persona;
import com.ayigroup.zieglerfrancisco.interfaces.DaoInterface;
import com.ayigroup.zieglerfrancisco.documento.DocumentoRepository;
import java.util.List;

public class PersonaDao implements DaoInterface<Persona>{
    
    private PersonaRepository PersonaRepository;
    private DocumentoRepository documentoRepository;

    public PersonaDao(PersonaRepository PersonaRepository, DocumentoRepository documentoRepository) {
        this.PersonaRepository = PersonaRepository;
        this.documentoRepository = documentoRepository;
    }
    
    @Override
    public List<Persona> getAll() {
        return PersonaRepository.getAll().stream().map((dto)->{return dtoToPersona(dto);}).toList();    
    }

    @Override
    public Persona getOne(int id) {
        return dtoToPersona(PersonaRepository.getOne(id));
    }
        
    public Persona getOneByDocumento(int documento) {
        return dtoToPersona(PersonaRepository.getOneByDocumento(documento));
    }

    @Override
    public Persona create(Persona newEntity) {
        documentoRepository.create(newEntity.getDocumento());
        return dtoToPersona(PersonaRepository.create(newEntity));
    }

    @Override
    public Persona update(Persona upEntity) {
        documentoRepository.update(upEntity.getDocumento());
        return dtoToPersona(PersonaRepository.update(upEntity));
    }

    @Override
    public Persona delete(Persona delEntity) {
        Persona persona = dtoToPersona(PersonaRepository.delete(delEntity));
        documentoRepository.delete(delEntity.getDocumento());
        return persona;
    }
    
    private Persona dtoToPersona(PersonaDTO dto){
        return new Persona(
                dto.idPersona(),
                dto.nombre(),
                dto.apellido(),
                documentoRepository.getOne(dto.numeroDocumento()));
    }
        
}
