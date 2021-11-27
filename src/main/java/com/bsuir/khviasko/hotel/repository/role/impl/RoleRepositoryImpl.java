package com.bsuir.khviasko.hotel.repository.role.impl;

import com.bsuir.khviasko.hotel.entity.Role;
import com.bsuir.khviasko.hotel.repository.AbstractRepository;
import com.bsuir.khviasko.hotel.repository.role.RoleRepository;

public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    public RoleRepositoryImpl() {
        super(Role.class, Role.ROLE_CLASS_NAME);
    }
}
