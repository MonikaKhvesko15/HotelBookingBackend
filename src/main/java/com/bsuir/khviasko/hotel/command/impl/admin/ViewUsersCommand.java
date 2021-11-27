package com.bsuir.khviasko.hotel.command.impl.admin;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ViewUsersCommand implements Command {
    UserRepository userRepository;

    public ViewUsersCommand() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        List<User> users = userRepository.findAll();
        writer.write(gson.toJson(users) + "\n");
        writer.flush();
    }
}
