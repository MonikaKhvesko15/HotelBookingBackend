package com.bsuir.khviasko.hotel.connection;

import lombok.Data;

@Data
public class QueryWrapper {
    private final String command;
    private final String userId;
    private final String role;
}
