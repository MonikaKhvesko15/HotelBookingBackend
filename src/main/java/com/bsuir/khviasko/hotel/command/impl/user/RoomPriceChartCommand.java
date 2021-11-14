package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;
import com.bsuir.khviasko.hotel.repository.room.impl.RoomRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class RoomPriceChartCommand implements Command {
    RoomRepository roomRepository;

    public RoomPriceChartCommand() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        Map<String, Double> map = roomRepository.getChartData();
        writer.write(gson.toJson(map) + "\n");
        writer.flush();
    }
}
