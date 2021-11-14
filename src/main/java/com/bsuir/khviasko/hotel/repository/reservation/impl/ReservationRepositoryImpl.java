package com.bsuir.khviasko.hotel.repository.reservation.impl;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepositoryImpl extends AbstractRepository<Reservation> implements ReservationRepository {
    public ReservationRepositoryImpl() {
        super(Reservation.class, Reservation.RESERVATION_CLASS_NAME);
    }

    @Override
    public void reserveRoom(Reservation reservation) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
        session.close();
    }
}
