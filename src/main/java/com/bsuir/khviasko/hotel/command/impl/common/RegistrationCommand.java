package com.bsuir.khviasko.hotel.command.impl.common;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RegistrationCommand implements Command {
    UserRepository userRepository;

    public RegistrationCommand() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = gson.fromJson(reader.readLine(), User.class);
        userRepository.addNewUser(user);
    }
}
