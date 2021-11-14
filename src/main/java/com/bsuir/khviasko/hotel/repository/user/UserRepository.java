package com.bsuir.khviasko.hotel.repository.user;

import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.Repository;

public interface UserRepository extends Repository<User> {
    User findByUsernameAndPassword(String username, String password);

    void addNewUser(User user);

    User findByID(String id);
}
