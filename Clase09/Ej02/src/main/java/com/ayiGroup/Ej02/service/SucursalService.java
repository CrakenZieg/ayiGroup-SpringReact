package com.ayiGroup.Ej02.service;

import com.ayiGroup.Ej02.persistence.entity.Sucursal;

import java.util.List;

public interface SucursalService {

    List<Sucursal> getAll();
    Sucursal getOne(int legajo);
    void save(Sucursal sucursal);
    void update(Sucursal sucursal);
    void delete(Sucursal sucursal);

}
