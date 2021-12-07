package com.bsuir.khviasko.hotel.repository.reservation.impl;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ReservationRepositoryImpl extends AbstractRepository<Reservation> implements ReservationRepository {
    public ReservationRepositoryImpl() {
        super(Reservation.class, Reservation.RESERVATION_CLASS_NAME);
    }


    @Override
    public double calculateTotalPrice(Room room, Reservation reservation) {
        return reservation.getDuration() * room.getPrice();
    }

    @Override
    public Reservation getUserReservation(User user) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Query query = session.createQuery("from Reservation r where r.user =:user");
        query.setParameter("user", user);
        Reservation entity = (Reservation) query.uniqueResult();
        session.close();
        return entity;
    }
}
