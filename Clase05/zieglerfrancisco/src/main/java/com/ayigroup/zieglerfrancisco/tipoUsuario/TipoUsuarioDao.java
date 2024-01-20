
package com.ayigroup.zieglerfrancisco.tipoUsuario;

import com.ayigroup.zieglerfrancisco.tipoUsuario.TipoUsuario;
import com.ayigroup.zieglerfrancisco.interfaces.DaoInterface;
import java.util.List;

public class TipoUsuarioDao implements DaoInterface<TipoUsuario>{
    
    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioDao(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public List<TipoUsuario> getAll() {
        return tipoUsuarioRepository.getAll();
    }

    @Override
    public TipoUsuario getOne(int id) {
        return tipoUsuarioRepository.getOne(id);
    }

    @Override
    public TipoUsuario create(TipoUsuario newEntity) {
        return tipoUsuarioRepository.create(newEntity);
    }

    @Override
    public TipoUsuario update(TipoUsuario upEntity) {
        return tipoUsuarioRepository.update(upEntity);
    }

    @Override
    public TipoUsuario delete(TipoUsuario delEntity) {
        return tipoUsuarioRepository.delete(delEntity);
    }
    
}
