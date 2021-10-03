package com.bsuir.khviasko.hotel.repository.reservation.impl;

import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;

public class ReservationRepositoryImpl extends AbstractRepository<Reservation> implements ReservationRepository {
    public ReservationRepositoryImpl() {
        super(Reservation.class, Reservation.RESERVATION_CLASS_NAME);
    }
}
