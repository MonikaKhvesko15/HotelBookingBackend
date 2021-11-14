package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReserveRoomCommand implements Command {
    ReservationRepository reservationRepository;

    public ReserveRoomCommand() {
        this.reservationRepository = new ReservationRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
       //todo: add logic
        Room room = gson.fromJson(reader.readLine(), Room.class);
        Reservation reservation =
        reservationRepository.reserveRoom();
    }
}
