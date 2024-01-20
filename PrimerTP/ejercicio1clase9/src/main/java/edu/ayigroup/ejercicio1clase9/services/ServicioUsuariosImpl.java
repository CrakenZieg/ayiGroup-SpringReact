package edu.ayigroup.ejercicio1clase9.services;

import edu.ayigroup.ejercicio1clase9.persistence.repository.IDAOUsuarios;
import edu.ayigroup.ejercicio1clase9.persistence.entities.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioUsuariosImpl implements ServicioUsuarios {

    @Autowired
    public IDAOUsuarios interfazDatoUsuarios;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios() {
        return (List<Usuarios>) interfazDatoUsuarios.findAll();
    }
}
