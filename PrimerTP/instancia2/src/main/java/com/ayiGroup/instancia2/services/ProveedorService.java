package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.repositories.entities.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> getAll();
    Proveedor getOne(int codigoProovedor);
    void save(Proveedor proveedor);
    void update(Proveedor proveedor);
    void delete(Proveedor proveedor);

}
