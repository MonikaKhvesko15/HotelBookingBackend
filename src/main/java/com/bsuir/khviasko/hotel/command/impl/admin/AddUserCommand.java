package com.bsuir.khviasko.hotel.command.impl.admin;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.role.RoleRepository;
import com.bsuir.khviasko.hotel.repository.role.impl.RoleRepositoryImpl;
import com.bsuir.khviasko.hotel.repository.user.UserRepository;
import com.bsuir.khviasko.hotel.repository.user.impl.UserRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AddUserCommand implements Command {

    UserRepository userRepository;
    RoleRepository roleRepository;

    public AddUserCommand() {
        this.userRepository = new UserRepositoryImpl();
        this.roleRepository = new RoleRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = gson.fromJson(reader.readLine(), User.class);
        user.setRole(roleRepository.findById("1"));
        userRepository.create(user);
    }
}
