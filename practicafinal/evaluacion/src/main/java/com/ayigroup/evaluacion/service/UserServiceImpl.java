package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.entities.User;
import com.ayigroup.evaluacion.persistence.repositories.UserRepository;
import com.ayigroup.evaluacion.security.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElse(null);
    }
    @Override
    @Transactional
    public User save(RegisterRequest dto) {
        return userRepository.save(dtoToUser(dto));
    }

    @Override
    @Transactional
    public void delete(int id) throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if(user!=null){
            userRepository.delete(user);
        }
    }

    private User dtoToUser(RegisterRequest dto){
        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        return user;
    }

}
