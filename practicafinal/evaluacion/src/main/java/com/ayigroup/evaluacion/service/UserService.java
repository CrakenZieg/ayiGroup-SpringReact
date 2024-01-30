package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.entities.User;
import com.ayigroup.evaluacion.security.dto.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    User save(RegisterRequest dto);
    void delete(int id);
}
