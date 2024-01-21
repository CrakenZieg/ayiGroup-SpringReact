package com.ayiGroup.instancia1.services;

import com.ayiGroup.instancia1.persistance.entities.Servicio;
import com.ayiGroup.instancia1.persistance.repositories.IServicioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServicioService {

    private static final Logger logger = LogManager.getLogger(ServicioService.class);

    @Autowired
    private IServicioRepository servicioRepository;

    public void agregar(Servicio servicio) throws Exception {
        logger.info("Intentando agregar un servicio con código EAN: {}", servicio.getCodigoEan());

        if (servicioRepository.existsByCodigoEan(servicio.getCodigoEan()) ||
                servicioRepository.existsByNombre(servicio.getNombre())) {
            logger.error("No se pudo agregar el servicio. Ya existe un servicio con el mismo código EAN o nombre.");
            throw new Exception("Ya existe un servicio con el mismo código EAN o nombre.");
        }

        servicioRepository.save(servicio);
        logger.info("Servicio agregado con éxito.");
    }

    public void eliminar(Integer id){
        logger.info("Intentando eliminar el servicio con ID: {}", id);

        if(servicioRepository.existsById(id)){
            servicioRepository.deleteById(id);
            logger.info("Servicio eliminado con éxito.");
        } else{
            logger.error("No se pudo eliminar el servicio. El ID no existe.");
            throw new NoSuchElementException("El código ingresado no pertenece a ningún servicio");
        }
    }

    public List<Servicio> listar(){
        logger.info("Obteniendo la lista de servicios.");
        return (List<Servicio>) servicioRepository.findAll();
    }
}
