package com.bsuir.khviasko.hotel.repository.room.impl;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.entity.RoomType;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;
import org.hibernate.Session;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class RoomRepositoryImpl extends AbstractRepository<Room> implements RoomRepository {

    public RoomRepositoryImpl() {
        super(Room.class, Room.ROOM_CLASS_NAME);
    }

    @Override
    public Map<String, Double> getChartData() {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        List<Room> rooms = findAll();
        session.close();
        Map<String, Double> map = new HashMap<>();
        double standartAveragePrice = sumPriceByType(rooms, RoomType.STANDARD) / countRoomsByType(rooms, RoomType.STANDARD);
        double businessAveragePrice = sumPriceByType(rooms, RoomType.BUSINESS) / countRoomsByType(rooms, RoomType.BUSINESS);
        double luxAveragePrice = sumPriceByType(rooms, RoomType.LUX) / countRoomsByType(rooms, RoomType.LUX);
        map.put(RoomType.STANDARD.name(), standartAveragePrice);
        map.put(RoomType.BUSINESS.name(), businessAveragePrice);
        map.put(RoomType.LUX.name(), luxAveragePrice);
        return map;
    }

    private Double sumPriceByType(List<Room> rooms, RoomType type){
        return Optional.ofNullable(rooms)
                .orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(room -> room.getType().equals(type))
                .mapToDouble(Room::getPrice).sum();
    }

    private long countRoomsByType(List<Room> rooms, RoomType type){
        return Optional.ofNullable(rooms)
                .orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(room -> room.getType().equals(type))
                .count();
    }
}
