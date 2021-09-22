package com.bsuir.khviasko.hotel.repository;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Reservation;
import org.hibernate.Session;

public class ReservationRepository {
    public Reservation findById(Long id) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Reservation reservation = session.get(Reservation.class, id);
        session.close();
        return reservation;
    }
}
