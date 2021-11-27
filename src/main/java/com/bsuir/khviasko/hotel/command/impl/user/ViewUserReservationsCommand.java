package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ViewUserReservationsCommand implements Command {
    ReservationRepository reservationRepository;

    public ViewUserReservationsCommand() {
        this.reservationRepository = new ReservationRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = gson.fromJson(reader.readLine(), User.class);
        List<Reservation> reservations = reservationRepository.getUserReservations(user);
        writer.write(gson.toJson(reservations) + "\n");
        writer.flush();
    }
}
