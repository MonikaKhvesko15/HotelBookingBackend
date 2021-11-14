package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;
import com.bsuir.khviasko.hotel.repository.room.impl.RoomRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ViewSingleRoomCommand implements Command {
    RoomRepository roomRepository;

    public ViewSingleRoomCommand() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        Room room = roomRepository.findById(queryWrapper.getRoomId());
        writer.write(gson.toJson(room) + "\n");
        writer.flush();
    }
}
