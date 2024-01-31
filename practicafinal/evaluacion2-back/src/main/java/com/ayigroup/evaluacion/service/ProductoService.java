package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.ProductoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.ProductoDTO;
import com.ayigroup.evaluacion.persistence.entities.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    List<Producto> getAll();
    Producto getOne(int id);
    void create(ProductoCreateRequest dto);
    void update(ProductoDTO dto);
    void delete(int id);
    List<ProductoDTO> getAllDTO();
    ProductoDTO getOneDTO(int id);

}

