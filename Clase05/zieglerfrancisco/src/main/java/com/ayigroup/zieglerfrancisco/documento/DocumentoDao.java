
package com.ayigroup.zieglerfrancisco.documento;

import com.ayigroup.zieglerfrancisco.documento.Documento;
import com.ayigroup.zieglerfrancisco.interfaces.DaoInterface;
import java.util.List;

public class DocumentoDao implements DaoInterface<Documento>{
    
    private DocumentoRepository documentoRespository;  

    public DocumentoDao(DocumentoRepository documentoRespository) {
        this.documentoRespository = documentoRespository;
    }

    @Override
    public List<Documento> getAll() {        
        return documentoRespository.getAll();
    }

    @Override
    public Documento getOne(int id) {        
        return documentoRespository.getOne(id);
    }

    @Override
    public Documento create(Documento newEntity) {
        return documentoRespository.create(newEntity);
    }
    
    @Override
    public Documento update(Documento upEntity) {        
        return documentoRespository.update(upEntity);
    }

    @Override
    public Documento delete(Documento delEntity) {        
        return documentoRespository.delete(delEntity);
    }
    
}
