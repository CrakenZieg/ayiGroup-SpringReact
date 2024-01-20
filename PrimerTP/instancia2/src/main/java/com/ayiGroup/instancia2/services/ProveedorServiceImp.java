package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.repositories.entities.Proveedor;
import com.ayiGroup.instancia2.repositories.repositories.ProovedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImp implements ProveedorService{

    @Autowired
    private ProovedorRepository proovedorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> getAll() {
        return (List<Proveedor>) proovedorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor getOne(int codigoProovedor) {
        return proovedorRepository.findById(codigoProovedor).orElseGet(()->{return null;});
    }

    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        proovedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public void update(Proveedor proveedor) {
        proovedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public void delete(Proveedor proveedor) {
        proovedorRepository.delete(proveedor);
    }
}
