package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.bsuir.khviasko.hotel.repository.reservationStatus.ReservationStatusRepository;
import com.bsuir.khviasko.hotel.repository.reservationStatus.impl.ReservationStatusRepositoryImpl;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ReserveRoomCommand implements Command {
    ReservationRepository reservationRepository;
    UserRepository userRepository;
    ReservationStatusRepository reservationStatusRepository;

    public ReserveRoomCommand() {
        this.reservationRepository = new ReservationRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
        this.reservationStatusRepository = new ReservationStatusRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = userRepository.findById(queryWrapper.getUserId());
        Room room = gson.fromJson(reader.readLine(), Room.class);
        String startDate = reader.readLine();
        String endDate = reader.readLine();

        Reservation reservation = new Reservation();
        reservation.setStartDate(LocalDate.parse(startDate));
        reservation.setEndDate(LocalDate.parse(endDate));
        reservation.setRoom(room);
        reservation.setUser(user);
        reservation.setReservationStatus(reservationStatusRepository.findById("1"));
        reservation.setTotalPrice(reservationRepository.calculateTotalPrice(room, reservation));

        reservationRepository.create(reservation);
    }
}
