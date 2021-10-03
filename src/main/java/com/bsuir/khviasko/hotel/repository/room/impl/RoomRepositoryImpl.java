package com.bsuir.khviasko.hotel.repository.room.impl;

import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;

public class RoomRepositoryImpl extends AbstractRepository<Room> implements RoomRepository {

    public RoomRepositoryImpl() {
        super(Room.class, Room.ROOM_CLASS_NAME);
    }
}
