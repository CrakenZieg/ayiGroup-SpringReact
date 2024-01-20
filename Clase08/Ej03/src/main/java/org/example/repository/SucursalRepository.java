package org.example.repository;

import org.example.entity.Sucursal;

import java.util.List;

public interface SucursalRepository {

    public List<Sucursal> getAll();
    public Sucursal getOne(int idSucursal);
    public void save(Sucursal sucursal);
    public void update(Sucursal sucursal);
    public void delete(Sucursal sucursal);
}
