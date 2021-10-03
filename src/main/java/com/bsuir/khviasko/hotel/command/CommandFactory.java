package com.bsuir.khviasko.hotel.command;

import com.bsuir.khviasko.hotel.command.impl.LoginCommand;
import com.bsuir.khviasko.hotel.command.impl.ReserveRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.ViewRoomsCommand;
import com.bsuir.khviasko.hotel.command.impl.ViewSingleRoomCommand;

public class CommandFactory {
    //user
    private static final String LOGIN_COMMAND = "login";

    //room
    private static final String VIEW_ROOMS_COMMAND = "view_rooms";
    private static final String VIEW_SINGLE_ROOM_COMMAND = "view_single_room";

    //reservation
    private static final String RESERVE_ROOM_COMMAND = "reserve_room";

    //comment

    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case VIEW_ROOMS_COMMAND:
                return new ViewRoomsCommand();
            case VIEW_SINGLE_ROOM_COMMAND:
                return new ViewSingleRoomCommand();
            case RESERVE_ROOM_COMMAND:
                return new ReserveRoomCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
