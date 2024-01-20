package com.ayiGroup.Ej02.service;

import com.ayiGroup.Ej02.persistence.entity.Sucursal;
import com.ayiGroup.Ej02.persistence.repository.SucursalRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImp implements SucursalService{

    private static final Logger logger = LoggerFactory.getLogger(SucursalServiceImp.class);

    @Autowired
    private SucursalRespository sucursalRespository;

    @Override
    public List<Sucursal> getAll() {
        logger.info("getAll()");
        return sucursalRespository.findAll();
    }

    @Override
    public Sucursal getOne(int legajo) {
        logger.info("getOne("+legajo+")");
        return sucursalRespository.findById(legajo).orElse(null);
    }

    @Override
    public void save(Sucursal sucursal) {
        logger.info("save("+sucursal+")");
        sucursalRespository.save(sucursal);
    }

    @Override
    public void update(Sucursal sucursal) {
        logger.info("update("+sucursal+")");
        sucursalRespository.save(sucursal);
    }

    @Override
    public void delete(Sucursal sucursal) {
        logger.info("delete("+sucursal+")");
        sucursalRespository.delete(sucursal);
    }
}
