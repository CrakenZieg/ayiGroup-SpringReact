
package com.ayigroup.zieglerfrancisco.usuario;

import com.ayigroup.zieglerfrancisco.documento.Documento;
import com.ayigroup.zieglerfrancisco.documento.DocumentoRepository;
import com.ayigroup.zieglerfrancisco.interfaces.DaoInterface;
import com.ayigroup.zieglerfrancisco.persona.Persona;
import com.ayigroup.zieglerfrancisco.persona.PersonaDTO;
import com.ayigroup.zieglerfrancisco.persona.PersonaRepository;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuario;
import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuarioRepository;
import java.util.List;

public class UsuarioDao implements DaoInterface<Usuario>{
    
    private TipoUsuarioRepository tipoUsuarioRepository;
    private DocumentoRepository documentoRepository;
    private PersonaRepository personaRepository;
    private UsuarioRepository usuarioRepository;

    public UsuarioDao(TipoUsuarioRepository tipoUsuarioRepository, DocumentoRepository documentoRepository, PersonaRepository personaRepository, UsuarioRepository usuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.documentoRepository = documentoRepository;
        this.personaRepository = personaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.getAll().stream().map((dto)->{return dtoToUsuario(dto);}).toList();   
    }

    @Override
    public Usuario getOne(int id) {
        return dtoToUsuario(usuarioRepository.getOne(id));
    }

    @Override
    public Usuario create(Usuario newEntity) {
        documentoRepository.create(newEntity.getPersona().getDocumento());
        personaRepository.create(newEntity.getPersona());
        return dtoToUsuario(usuarioRepository.create(newEntity));
    }

    @Override
    public Usuario update(Usuario upEntity) {
        documentoRepository.update(upEntity.getPersona().getDocumento());
        personaRepository.update(upEntity.getPersona());        
        tipoUsuarioRepository.update(upEntity.getTipoUsuario());
        return dtoToUsuario(usuarioRepository.update(upEntity));
    }

    @Override
    public Usuario delete(Usuario delEntity) {
        Usuario usuario = dtoToUsuario(usuarioRepository.update(delEntity));
        personaRepository.delete(delEntity.getPersona());
        documentoRepository.delete(delEntity.getPersona().getDocumento());
        return usuario;
    }
    
    private Usuario dtoToUsuario(UsuarioDTO dto){        
        PersonaDTO personaDTO = personaRepository.getOne(dto.persona());
        Documento documento = documentoRepository.getOne(personaDTO.numeroDocumento());
        Persona persona = new Persona(personaDTO.idPersona(),personaDTO.nombre(), personaDTO.apellido(), documento);
        TipoUsuario tipoUsuario = tipoUsuarioRepository.getOne(dto.tipoUsuario());
        Usuario usuario = new Usuario(
                dto.idUsuario(), 
                dto.nombreUsuario(), 
                dto.password(), 
                persona, 
                tipoUsuario);
        return usuario;
    }
    
}
