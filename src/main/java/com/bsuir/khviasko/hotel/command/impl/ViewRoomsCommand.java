package com.bsuir.khviasko.hotel.command.impl;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;
import com.bsuir.khviasko.hotel.repository.room.impl.RoomRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ViewRoomsCommand implements Command {
    RoomRepository roomRepository;

    public ViewRoomsCommand() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        List<Room> rooms = roomRepository.findAll();
        writer.write(gson.toJson(rooms) + "\n");
        writer.flush();
    }
}
