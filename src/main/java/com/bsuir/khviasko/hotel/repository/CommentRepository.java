package com.bsuir.khviasko.hotel.repository;

import com.bsuir.khviasko.hotel.config.HibernateSessionCreator;
import com.bsuir.khviasko.hotel.entity.Comment;
import org.hibernate.Session;

public class CommentRepository {
    public Comment findById(Long id) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        Comment comment = session.get(Comment.class, id);
        session.close();
        return comment;
    }
}
