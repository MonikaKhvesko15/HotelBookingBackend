package com.bsuir.khviasko.hotel.repository.comment.impl;

import com.bsuir.khviasko.hotel.entity.Comment;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.comment.CommentRepository;

public class CommentRepositoryImpl extends AbstractRepository<Comment> implements CommentRepository {
    public CommentRepositoryImpl() {
        super(Comment.class, Comment.COMMENT_CLASS_NAME);
    }
}
