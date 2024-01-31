package com.ayigroup.evaluacion.service;

import com.ayigroup.evaluacion.persistence.dto.ProductoCreateRequest;
import com.ayigroup.evaluacion.persistence.dto.ProductoDTO;
import com.ayigroup.evaluacion.persistence.entities.Producto;
import com.ayigroup.evaluacion.persistence.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getAll() {
        return productoRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getOne(int id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void create(ProductoCreateRequest dto) {
        productoRepositorio.save(createDtoToProducto(dto));
    }

    @Override
    @Transactional
    public void update(ProductoDTO dto) {
        productoRepositorio.save(dtoToProducto(dto));
    }

    @Override
    @Transactional
    public void delete(int id) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        if(producto != null){
            productoRepositorio.delete(producto);
        }
    }

    @Override
    public List<ProductoDTO> getAllDTO(){
        List<Producto> productos = getAll();
        if(!productos.isEmpty()) {
            return productos.stream().map(
                    (producto) -> {
                        return new ProductoDTO(
                                producto.getId(),
                                producto.getEan(),
                                producto.getNombre(),
                                producto.getDescripcion(),
                                producto.getTipo(),
                                producto.getMarca(),
                                producto.getPrecio(),
                                producto.getStock()
                        );
                    }).toList();
        }
        return new ArrayList<ProductoDTO>();
    }

    @Override
    public ProductoDTO getOneDTO(int id) {
        Producto producto = getOne(id);
        if(producto!=null){
            return new ProductoDTO(
                producto.getId(),
                producto.getEan(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getTipo(),
                producto.getMarca(),
                producto.getPrecio(),
                producto.getStock()
            );
        }
        return null;
    }

    private Producto dtoToProducto(ProductoDTO dto){
        return Producto.builder()
                .id(dto.id())
                .ean(dto.ean())
                .nombre(dto.nombre())
                .descripcion(dto.descripcion())
                .tipo(dto.tipo())
                .marca(dto.marca())
                .precio(dto.precio())
                .stock(dto.stock())
                .build();
    }

    private Producto createDtoToProducto(ProductoCreateRequest dto){
        return Producto.builder()
                .ean(dto.ean())
                .nombre(dto.nombre())
                .descripcion(dto.descripcion())
                .tipo(dto.tipo())
                .marca(dto.marca())
                .precio(dto.precio())
                .stock(dto.stock())
                .build();
    }
}
