package com.bsuir.khviasko.hotel.repository;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T> {
    private final Class<T> entityClass;
    private final String className;

    protected AbstractRepository(Class<T> entityClass, String className) {
        this.entityClass = entityClass;
        this.className = className;
    }

    @Override
    public T findById(String id) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        T entity = session.get(entityClass, Long.parseLong(id));
        session.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Query query = session.createQuery("from " + className);
        List<T> entities = query.list();
        session.close();
        return entities;
    }

    @Override
    public void create(T entity) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(T entity) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(T entity) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }
}
