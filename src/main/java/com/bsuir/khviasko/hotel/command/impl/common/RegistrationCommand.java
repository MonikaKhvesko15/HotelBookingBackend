package com.bsuir.khviasko.hotel.command.impl.common;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.role.RoleRepository;
import com.bsuir.khviasko.hotel.repository.role.impl.RoleRepositoryImpl;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.security.MessageDigest;

public class RegistrationCommand implements Command {
    UserRepository userRepository;
    RoleRepository roleRepository;

    public RegistrationCommand() {
        this.userRepository = new UserRepositoryImpl();
        this.roleRepository = new RoleRepositoryImpl();
    }

    @Override
    @SneakyThrows
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        String firstname = reader.readLine();
        String surname = reader.readLine();
        String username = reader.readLine();
        String password = reader.readLine();

        User user = new User();
        user.setFirstname(firstname);
        user.setSurname(surname);
        user.setLogin(username);
        user.setDeleted(false);
        user.setRole(roleRepository.findById("2"));

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(password.getBytes());
        String securePassword = "";
        for(byte b:bytes){
            securePassword += b;
        }
        user.setPassword(securePassword);

        userRepository.create(user);
    }
}
