package com.bsuir.khviasko.hotel.repository.reservationStatus.impl;

import com.bsuir.khviasko.hotel.entity.ReservationStatus;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.reservationStatus.ReservationStatusRepository;

public class ReservationStatusRepositoryImpl extends AbstractRepository<ReservationStatus> implements ReservationStatusRepository {

    public ReservationStatusRepositoryImpl() {
        super(ReservationStatus.class, ReservationStatus.RESERVATION_CLASS_NAME);
    }
}
