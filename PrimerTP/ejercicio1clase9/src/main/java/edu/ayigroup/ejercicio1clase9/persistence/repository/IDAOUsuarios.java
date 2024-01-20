package edu.ayigroup.ejercicio1clase9.persistence.repository;

import edu.ayigroup.ejercicio1clase9.persistence.entities.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface IDAOUsuarios extends CrudRepository<Usuarios, Integer> {
}
