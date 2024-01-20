
package com.ayigroup.zieglerfrancisco.usuario;

import java.util.List;

public class UsuarioService {
    
    private UsuarioDao usuarioDao;  

    public UsuarioService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<Usuario> getAll() {        
        return usuarioDao.getAll();
    }

    public Usuario getOne(int id) throws Exception {   
        validateNumber(id);
        return usuarioDao.getOne(id);
    }

    public Usuario create(Usuario newEntity) throws Exception {
        validadateUser(newEntity);
        return usuarioDao.create(newEntity);
    }
    
    public Usuario update(Usuario upEntity) throws Exception {         
        validateNumber(upEntity.getIdUsuario());
        validadateUser(upEntity);
        return usuarioDao.update(upEntity);
    }

    public Usuario delete(Usuario delEntity) throws Exception {  
        validateNumber(delEntity.getIdUsuario());
        return usuarioDao.delete(delEntity);
    }
    
    private void validateNumber(int num) throws Exception{
        if(num==0){
            throw new Exception("El numero de id no puede ser cero");
        }
    }
    
    private void validadateUser(Usuario entity) throws Exception{
        if(entity.getNombreUsuario().isBlank()){
            throw new Exception("El nombre de usuario no puede estar vacío");
        }
        if(entity.getPassword().isBlank()){
            throw new Exception("El password no puede estar vacío");
        }        
        if(entity.getPersona()==null||
                entity.getPersona().getNombre().isBlank()||
                entity.getPersona().getApellido().isBlank()){
            throw new Exception("La persona asociada no puede estar vacía");
        }   
        if(entity.getPersona().getDocumento()==null||
                entity.getPersona().getDocumento().getDescripcion().isBlank()){            
            throw new Exception("El documento asociado no puede estar vacío");
        }
        if(entity.getTipoUsuario()==null||entity.getTipoUsuario().getIdTipoUsuario()==0||entity.getTipoUsuario().getDescripcion().isBlank()){
            throw new Exception("El tipo de usuario no puede estar vacío");
        }        
    }
    
}