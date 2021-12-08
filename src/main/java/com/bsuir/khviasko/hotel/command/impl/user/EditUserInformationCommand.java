package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.security.MessageDigest;

public class EditUserInformationCommand implements Command {
    private UserRepository userRepository;

    public EditUserInformationCommand() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    @SneakyThrows
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = gson.fromJson(reader.readLine(), User.class);

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(user.getPassword().getBytes());
        String securePassword = "";
        for (byte b : bytes) {
            securePassword += b;
        }

        user.setPassword(securePassword);
        userRepository.update(user);
    }
}
