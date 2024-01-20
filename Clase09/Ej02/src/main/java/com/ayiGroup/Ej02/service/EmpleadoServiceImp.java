package com.ayiGroup.Ej02.service;

import com.ayiGroup.Ej02.persistence.entity.Empleado;
import com.ayiGroup.Ej02.persistence.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoServiceImp.class);

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> getAll() {
        logger.info("getAll()");
        return empleadoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado getOne(String legajo) {
        logger.info("getOne("+legajo+")");
        return empleadoRepository.findById(legajo).orElse(null);
    }

    @Override
    @Transactional
    public void save(Empleado empleado) {
        logger.info("save("+empleado+")");
        empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void update(Empleado empleado) {
        logger.info("update("+empleado+")");
        empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Empleado empleado) {
        logger.info("delete("+empleado+")");
        empleadoRepository.delete(empleado);
    }

}
