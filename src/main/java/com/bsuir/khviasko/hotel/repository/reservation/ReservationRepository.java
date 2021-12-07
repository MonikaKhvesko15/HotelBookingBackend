package com.bsuir.khviasko.hotel.repository.reservation;

import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.Repository;

import java.util.List;

public interface ReservationRepository extends Repository<Reservation> {
     double calculateTotalPrice(Room room, Reservation reservation);

     Reservation getUserReservation(User user);
}
