package com.bsuir.khviasko.hotel.command.impl;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.UserRepository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class LoginCommand implements Command {
    UserRepository userRepository;

    public LoginCommand() {
        this.userRepository = new UserRepository();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson) throws IOException {
        String username = reader.readLine();
        String password = reader.readLine();
        User user = userRepository.findByUsernameAndPassword(username, password);

        if (Objects.nonNull(user)) {
            if (!user.isBlocked()) {
                writer.write(gson.toJson(user) + "\n");
            } else {
                writer.write("User is blocked" + "\n");
            }
        } else {
            writer.write("User not found" + "\n");
        }
        writer.flush();
    }
}
