package com.bsuir.khviasko.hotel.config;

import com.bsuir.khviasko.hotel.entity.Comment;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.Role;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionCreator {
    private static SessionFactory sessionFactory;

    private HibernateSessionCreator() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(Reservation.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Something went wrong" + e);
            }
        }
        return sessionFactory;
    }
}
