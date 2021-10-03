package com.bsuir.khviasko.hotel.repository.user.impl;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class, User.USER_CLASS_NAME);
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
