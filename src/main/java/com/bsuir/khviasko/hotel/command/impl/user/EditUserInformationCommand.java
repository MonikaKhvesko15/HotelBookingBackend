package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class EditUserInformationCommand implements Command {
    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        //todo: add logic
    }
}
