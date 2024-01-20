package org.example.repository;

import org.example.entity.Empleado;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmpleadoRepositoryImp implements EmpleadoRepository {

    private static final Logger logger = LogManager.getLogger(EmpleadoRepositoryImp.class);
    private SessionFactory sessionFactory;

    public EmpleadoRepositoryImp(){
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empleado.class).buildSessionFactory();
    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> empleados = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Empleado> query = session.createQuery("from Empleado");
            empleados = query.list();
            logger.info("Acceso a todos los registros");
        } catch (Exception ex){
            logger.error("Error: "+ex);
        } finally {
            session.close();
        }
        return empleados;
    }

    @Override
    public Empleado getOne(String idEmpleado) {
        Empleado empleado = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            empleado = session.get(Empleado.class, idEmpleado);
            transaction.commit();
            logger.info("Acceso al registro: "+ empleado.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
        return empleado;
    }

    @Override
    public void save(Empleado empleado) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
            logger.info("Persistencia del registro: "+ empleado.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Empleado empleado) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(empleado);
            transaction.commit();
            logger.info("Actualización del registro: "+ empleado.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Empleado empleado) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(empleado);
            transaction.commit();
            logger.info("Eliminación del registro: "+ empleado.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
