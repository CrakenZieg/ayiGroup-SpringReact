package com.ayigroup.evaluacion.persistence.repositories;

import com.ayigroup.evaluacion.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

}
