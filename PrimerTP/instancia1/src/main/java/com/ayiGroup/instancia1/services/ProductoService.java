package com.ayiGroup.instancia1.services;

import com.ayiGroup.instancia1.persistance.entities.Producto;
import com.ayiGroup.instancia1.persistance.repositories.IProductoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductoService {

    private static final Logger logger = LogManager.getLogger(ProductoService.class);

    @Autowired
    private IProductoRepository productoRepository;

    public void agregar(Producto producto) throws Exception {
        logger.info("Intentando agregar un producto con código EAN: {}", producto.getCodigoEan());

        if (productoRepository.existsByCodigoEan(producto.getCodigoEan()) ||
                productoRepository.existsByNombre(producto.getNombre())) {
            logger.error("No se pudo agregar el producto. Ya existe un producto con el mismo código EAN o nombre.");
            throw new Exception("Ya existe un producto con el mismo código EAN o nombre.");
        }

        productoRepository.save(producto);
        logger.info("Producto agregado con éxito.");
    }

    public void eliminar(Integer id){
        logger.info("Intentando eliminar el producto con ID: {}", id);

        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            logger.info("Producto eliminado con éxito.");
        } else{
            logger.error("No se pudo eliminar el producto. El ID no existe.");
            throw new NoSuchElementException("El código ingresado no pertenece a ningún producto");
        }
    }

    public List<Producto> listar(){
        logger.info("Obteniendo la lista de productos.");
        return (List<Producto>) productoRepository.findAll();
    }
}
