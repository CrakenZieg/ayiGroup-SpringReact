
package com.ayigroup.zieglerfrancisco.documento;

import java.util.List;

public class DocumentoService {
    
    private DocumentoDao documentoDao;  

    public DocumentoService(DocumentoDao documentoDao) {
        this.documentoDao = documentoDao;
    }

    public List<Documento> getAll() {        
        return documentoDao.getAll();
    }

    public Documento getOne(int id) throws Exception {   
        validateNumber(id);
        return documentoDao.getOne(id);
    }

    public Documento create(Documento newEntity) throws Exception {
        validateNumber(newEntity.getNumeroDocumento());
        validateDescription(newEntity.getDescripcion());
        return documentoDao.create(newEntity);
    }
    
    public Documento update(Documento upEntity) throws Exception {   
        validateNumber(upEntity.getNumeroDocumento());
        validateDescription(upEntity.getDescripcion());
        return documentoDao.update(upEntity);
    }

    public Documento delete(Documento delEntity) throws Exception {  
        validateNumber(delEntity.getNumeroDocumento());
        return documentoDao.delete(delEntity);
    }
    
    private void validateNumber(int num) throws Exception{
        if(num==0){
            throw new Exception("El numero de documento no puede ser cero");
        }
    }
    
    private void validateDescription(String desc) throws Exception{
        if(desc.isBlank()){
            throw new Exception("La descripcion no puede estar vacía");
        }
    }
    
}