package org.example.persistence.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.persistence.entity.Empleado;
import org.example.persistence.entity.Sucursal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SucursarlRepositoryImp implements SucursalRepository{

    private static final Logger logger = LogManager.getLogger(SucursarlRepositoryImp.class);
    private SessionFactory sessionFactory;

    public SucursarlRepositoryImp(){
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empleado.class).buildSessionFactory();
    }

    @Override
    public List<Sucursal> getAll() {
        List<Sucursal> sucursales = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Sucursal> query = session.createQuery("from Sucursal");
            sucursales = query.list();
            logger.info("Acceso a todos los registros");
        } catch (Exception ex){
            logger.error("Error: "+ex);
        } finally {
            session.close();
        }
        return sucursales;
    }

    @Override
    public Sucursal getOne(int idSucursal) {
        Sucursal sucursal = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            sucursal = session.get(Sucursal.class, idSucursal);
            transaction.commit();
            logger.info("Acceso al registro: "+ sucursal.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
        return sucursal;
    }

    @Override
    public void save(Sucursal sucursal) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(sucursal);
            transaction.commit();
            logger.info("Persistencia del registro: "+ sucursal.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Sucursal sucursal) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(sucursal);
            transaction.commit();
            logger.info("Actualización del registro: "+ sucursal.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Sucursal sucursal) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(sucursal);
            transaction.commit();
            logger.info("Eliminación del registro: "+ sucursal.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
