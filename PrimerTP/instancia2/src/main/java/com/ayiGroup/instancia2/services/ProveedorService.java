package com.ayiGroup.instancia2.services;

import com.ayiGroup.instancia2.persistence.entities.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> getAll();
    Proveedor getOne(Proveedor proveedor);
    void save(Proveedor proveedor);
    void delete(Proveedor proveedor);

}
