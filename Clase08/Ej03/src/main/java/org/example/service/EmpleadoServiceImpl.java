package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Empleado;
import org.example.repository.EmpleadoRepository;
import org.example.repository.EmpleadoRepositoryImp;

import java.util.List;

public class EmpleadoServiceImpl implements EmpleadoService {

    private static final Logger logger = LogManager.getLogger(EmpleadoServiceImpl.class);
    private EmpleadoRepository empleadoRepository = new EmpleadoRepositoryImp();

    public List<Empleado> getAll(){
        logger.info("Llamado al getAll()");
        return empleadoRepository.getAll();
    }

    public Empleado getOne(String id){
        logger.info("Llamado al getOne("+id+")");
        return empleadoRepository.getOne(id);
    }

    public void save(Empleado empleado){
        logger.info("Llamado al save("+ empleado.toString()+")");
        if(empleado.getIdEmpleado()!=null){
            empleadoRepository.update(empleado);
        }else{
            empleadoRepository.save(empleado);
        }
    }

    public void delete(Empleado empleado){
        logger.info("Llamado al delete("+ empleado.getIdEmpleado()+")");
        if(empleado.getIdEmpleado()!=null){
            empleadoRepository.delete(empleado);
        }
    }

}
