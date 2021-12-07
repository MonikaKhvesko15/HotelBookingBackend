package com.bsuir.khviasko.hotel.command.impl.admin;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.bsuir.khviasko.hotel.repository.reservationStatus.ReservationStatusRepository;
import com.bsuir.khviasko.hotel.repository.reservationStatus.impl.ReservationStatusRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ApproveReservationCommand implements Command {
    private final ReservationRepository reservationRepository;
    private final ReservationStatusRepository reservationStatusRepository;

    public ApproveReservationCommand() {
        reservationRepository = new ReservationRepositoryImpl();
        reservationStatusRepository = new ReservationStatusRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        Reservation reservation = reservationRepository.findById(queryWrapper.getReservationId());
        reservation.setReservationStatus(reservationStatusRepository.findById("2"));
        reservationRepository.update(reservation);
    }
}
