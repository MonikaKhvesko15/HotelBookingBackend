package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ViewUserReservationCommand implements Command {
    ReservationRepository reservationRepository;
    UserRepository userRepository;

    public ViewUserReservationCommand() {
        this.reservationRepository = new ReservationRepositoryImpl();
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = userRepository.findById(queryWrapper.getUserId());
        Reservation reservation = reservationRepository.getUserReservation(user);

        if(reservation == null){
            writer.write(gson.toJson("EMPTY") + "\n");
        }else {
            writer.write(gson.toJson(reservation) + "\n");
        }
        writer.flush();
    }
}
