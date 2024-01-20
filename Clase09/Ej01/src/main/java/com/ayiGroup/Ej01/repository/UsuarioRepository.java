package com.ayiGroup.Ej01.repository;

import com.ayiGroup.Ej01.entity.Usuario2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario2,String> {
}
