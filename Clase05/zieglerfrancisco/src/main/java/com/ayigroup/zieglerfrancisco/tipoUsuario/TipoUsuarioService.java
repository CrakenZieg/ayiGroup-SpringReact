
package com.ayigroup.zieglerfrancisco.tipoUsuario;

import java.util.List;

public class TipoUsuarioService {
    
    private TipoUsuarioDao tipoUsuarioDao;

    public TipoUsuarioService(TipoUsuarioDao tipoUsuarioDao) {
        this.tipoUsuarioDao = tipoUsuarioDao;
    }
    
    public List<TipoUsuario> getAll() {        
        return tipoUsuarioDao.getAll();
    }

    public TipoUsuario getOne(int id) throws Exception {   
        validateNumber(id);
        return tipoUsuarioDao.getOne(id);
    }

    public TipoUsuario create(TipoUsuario newEntity) throws Exception {
        validateDescription(newEntity.getDescripcion());
        return tipoUsuarioDao.create(newEntity);
    }
    
    public TipoUsuario update(TipoUsuario upEntity) throws Exception {
        validateNumber(upEntity.getIdTipoUsuario());
        validateDescription(upEntity.getDescripcion());
        return tipoUsuarioDao.update(upEntity);
    }

    public TipoUsuario delete(TipoUsuario delEntity) throws Exception {  
        validateNumber(delEntity.getIdTipoUsuario());
        return tipoUsuarioDao.delete(delEntity);
    }
    
    private void validateNumber(int num) throws Exception{
        if(num==0){
            throw new Exception("El numero identificación del tipo no puede ser cero");
        }
    }
    
    private void validateDescription(String desc) throws Exception{
        if(desc.isBlank()){
            throw new Exception("La descripcion no puede estar vacía");
        }
    }
    
}
