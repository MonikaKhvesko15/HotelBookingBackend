package com.bsuir.khviasko.hotel.repository;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRepository {
    public User findById(Long id) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public User findByUsernameAndPassword(String username, String password) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Query query =
                session.createQuery("from User u where u.login =:username and u.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user =  (User) query.uniqueResult();
        session.close();
        return user;
    }
}
