package org.example.repository;

import org.example.entity.Persona;

import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonaRepositoryImp implements PersonaRepository{

    private static final Logger logger = LogManager.getLogger(PersonaRepositoryImp.class);
    private SessionFactory sessionFactory;

    public PersonaRepositoryImp(){
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Persona.class).buildSessionFactory();
    }

    @Override
    public List<Persona> getAll() {
        List<Persona> personas = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Persona> query = session.createQuery("from Persona");
            personas = query.list();
            logger.info("Acceso a todos los registros");
        } catch (Exception ex){
            logger.error("Error: "+ex);
        } finally {
            session.close();
        }
        return personas;
    }

    @Override
    public Persona getOne(String idPersona) {
        Persona persona = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            persona = session.get(Persona.class, idPersona);
            transaction.commit();
            logger.info("Acceso al registro: "+persona.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
        return persona;
    }

    @Override
    public void save(Persona persona) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(persona);
            transaction.commit();
            logger.info("Persistencia del registro: "+persona.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Persona persona) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(persona);
            transaction.commit();
            logger.info("Actualización del registro: "+persona.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Persona persona) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(persona);
            transaction.commit();
            logger.info("Eliminación del registro: "+persona.toString());
        } catch (Exception ex){
            logger.error("Error: "+ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
