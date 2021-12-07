package com.bsuir.khviasko.hotel.repository.room.impl;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Room;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.room.RoomRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public List<Room> findAll() {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Query query = session.createQuery("from Room u where u.isDeleted =:flag");
        query.setParameter("flag", false);
        List<Room> entities = query.list();
        session.close();
        return entities;
    }

}
