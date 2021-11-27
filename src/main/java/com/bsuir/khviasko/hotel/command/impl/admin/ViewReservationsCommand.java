package com.bsuir.khviasko.hotel.command.impl.admin;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ViewReservationsCommand implements Command {
    ReservationRepository reservationRepository;

    public ViewReservationsCommand() {
        this.reservationRepository = new ReservationRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        List<Reservation> reservations = reservationRepository.findAll();
        writer.write(gson.toJson(reservations) + "\n");
        writer.flush();
    }
}
