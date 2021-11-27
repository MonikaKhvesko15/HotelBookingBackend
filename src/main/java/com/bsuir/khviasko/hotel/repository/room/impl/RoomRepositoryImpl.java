package com.bsuir.khviasko.hotel.repository.room.impl;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Room;
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

    private static final String STANDARD = "STANDARD";
    private static final String BUSINESS = "BUSINESS";
    private static final String LUX = "LUX";

    public RoomRepositoryImpl() {
        super(Room.class, Room.ROOM_CLASS_NAME);
    }

    @Override
    public Map<String, Double> getChartData() {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        List<Room> rooms = findAll();
        session.close();
        Map<String, Double> map = new HashMap<>();
        double standartAveragePrice = sumPriceByType(rooms, STANDARD) / countRoomsByType(rooms, STANDARD);
        double businessAveragePrice = sumPriceByType(rooms, BUSINESS) / countRoomsByType(rooms, BUSINESS);
        double luxAveragePrice = sumPriceByType(rooms, LUX) / countRoomsByType(rooms, LUX);
        map.put(STANDARD, standartAveragePrice);
        map.put(BUSINESS, businessAveragePrice);
        map.put(LUX, luxAveragePrice);
        return map;
    }

    private Double sumPriceByType(List<Room> rooms, String type) {
        return Optional.ofNullable(rooms)
                .orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(room -> room.getRoomType().equals(type))
                .mapToDouble(Room::getPrice).sum();
    }

    private long countRoomsByType(List<Room> rooms, String type) {
        return Optional.ofNullable(rooms)
                .orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(room -> room.getRoomType().equals(type))
                .count();
    }
}
