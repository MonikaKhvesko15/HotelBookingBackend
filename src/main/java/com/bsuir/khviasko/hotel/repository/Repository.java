package com.bsuir.khviasko.hotel.repository;

import java.util.List;

public interface Repository<T> {
    T findById(String id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
