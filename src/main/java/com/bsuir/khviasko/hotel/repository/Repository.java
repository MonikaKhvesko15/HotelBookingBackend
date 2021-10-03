package com.bsuir.khviasko.hotel.repository;

import java.util.List;

public interface Repository<T> {
    T findById(String id);

    List<T> findAll();
}
