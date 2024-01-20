package org.example.repository;

import org.example.entity.Clientes;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientesRepositoryImp implements ClientesRepository {

    private static final Logger logger = LogManager.getLogger(ClientesRepositoryImp.class);
    private SessionFactory sessionFactory;

    public ClientesRepositoryImp(){
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class).buildSessionFactory();
    }

    @Override
    public List<Clientes> getAll() {
        List<Clientes> clientes = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Clientes> query = session.createQuery("from Clientes");
            clientes = query.list();
            logger.info("Acceso a todos los registros");
        } catch (Exception ex){
            logger.error("Error: "+ex);
        } finally {
            session.close();
        }
        return clientes;
    }

    @Override
    public Clientes getOne(int idCliente) {
        Clientes clientes = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            clientes = session.get(Clientes.class, idCliente);
            transaction.commit();
            logger.info("Acceso al registro: "+ clientes.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
        return clientes;
    }

    @Override
    public void save(Clientes clientes) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(clientes);
            transaction.commit();
            logger.info("Persistencia del registro: "+ clientes.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Clientes clientes) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(clientes);
            transaction.commit();
            logger.info("Actualización del registro: "+ clientes.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Clientes clientes) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(clientes);
            transaction.commit();
            logger.info("Eliminación del registro: "+ clientes.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
