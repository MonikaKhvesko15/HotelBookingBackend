package com.bsuir.khviasko.hotel.command.impl.admin;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;
import com.bsuir.khviasko.hotel.repository.room.impl.RoomRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AddRoomCommand implements Command {
    private RoomRepository roomRepository;

    public AddRoomCommand() {
        roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        String number = reader.readLine();
        String type = reader.readLine();
        String capacity = reader.readLine();
        String price = reader.readLine();
        String description = reader.readLine();

        Room room = new Room();
        room.setRoomNumber(number);
        room.setRoomType(type);
        room.setCapacity(Integer.parseInt(capacity));
        room.setPrice(Double.parseDouble(price));
        room.setDescription(description);
        room.setDeleted(false);
        roomRepository.create(room);
    }
}
