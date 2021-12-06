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
import java.util.Objects;

public class LoginCommand implements Command {
    UserRepository userRepository;

    public LoginCommand() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        String username = reader.readLine();
        String password = reader.readLine();
        User user = userRepository.findByUsernameAndPassword(username, password);

        if (Objects.nonNull(user)) {
            writer.write(gson.toJson(user) + "\n");
        } else {
            writer.write(gson.toJson("REJECTED") + "\n");
        }
        writer.flush();
    }
}
