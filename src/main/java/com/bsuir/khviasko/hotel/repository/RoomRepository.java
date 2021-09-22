package com.bsuir.khviasko.hotel.repository;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Room;
import org.hibernate.Session;

public class RoomRepository {
    public Room findById(Long id) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Room room = session.get(Room.class, id);
        session.close();
        return room;
    }
}
