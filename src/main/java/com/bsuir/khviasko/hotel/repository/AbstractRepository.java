package com.bsuir.khviasko.hotel.repository;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public abstract class AbstractRepository<T> implements Repository<T> {
    private final Class<T> entityClass;
    private final String className;

    public AbstractRepository(Class<T> entityClass, String className) {
        this.entityClass = entityClass;
        this.className = className;
    }

    @Override
    public T findById(String id) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Query query = session.createQuery("from "+ className);
        List<T> entities= query.list();
        session.close();
        return entities;
    }
}
