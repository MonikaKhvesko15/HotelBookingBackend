package com.bsuir.khviasko.hotel.command;

import com.bsuir.khviasko.hotel.command.impl.admin.AddRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.ApproveReservationCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.DeclineReservationCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.DeleteRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.DeleteUserCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.EditRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.ViewReservationsCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.ViewUsersCommand;
import com.bsuir.khviasko.hotel.command.impl.common.LoginCommand;
import com.bsuir.khviasko.hotel.command.impl.common.RegistrationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.EditUserInformationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ReserveRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ResetReservationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewRoomsCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewSingleRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewUserInformationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewUserReservationCommand;

public class CommandFactory {

    //common
    private static final String LOGIN_COMMAND = "login";
    private static final String REGISTRATION_COMMAND = "registration";

    //user
    private static final String VIEW_USER_COMMAND = "view_user";
    private static final String EDIT_USER_COMMAND = "edit_user";
    private static final String VIEW_ROOMS_COMMAND = "view_rooms";
    private static final String VIEW_SINGLE_ROOM_COMMAND = "view_room";
    private static final String RESERVE_ROOM_COMMAND = "reserve_room";
    private static final String RESET_RESERVATION_COMMAND = "reset_reservation";
    private static final String VIEW_USER_RESERVATION_COMMAND = "view_user_reservation";

    //admin
    private static final String VIEW_USERS_COMMAND = "view_users";
    private static final String DELETE_USER_COMMAND = "delete_user";
    private static final String ADD_ROOM_COMMAND = "add_room";
    private static final String DELETE_ROOM_COMMAND = "delete_room";
    private static final String EDIT_ROOM_COMMAND = "edit_room";
    private static final String VIEW_RESERVATIONS_COMMAND = "view_reservations";
    private static final String APPROVE_RESERVATION_COMMAND = "approve_reservation";
    private static final String DECLINE_RESERVATION_COMMAND = "decline_reservation";

    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case REGISTRATION_COMMAND:
                return new RegistrationCommand();
            case VIEW_USER_COMMAND:
                return new ViewUserInformationCommand();
            case EDIT_USER_COMMAND:
                return new EditUserInformationCommand();
            case VIEW_ROOMS_COMMAND:
                return new ViewRoomsCommand();
            case VIEW_SINGLE_ROOM_COMMAND:
                return new ViewSingleRoomCommand();
            case RESERVE_ROOM_COMMAND:
                return new ReserveRoomCommand();
            case RESET_RESERVATION_COMMAND:
                return new ResetReservationCommand();
            case VIEW_USER_RESERVATION_COMMAND:
                return new ViewUserReservationCommand();
            case VIEW_USERS_COMMAND:
                return new ViewUsersCommand();
            case DELETE_USER_COMMAND:
                return new DeleteUserCommand();
            case VIEW_RESERVATIONS_COMMAND:
                return new ViewReservationsCommand();
            case DELETE_ROOM_COMMAND:
                return new DeleteRoomCommand();
            case ADD_ROOM_COMMAND:
                return new AddRoomCommand();
            case EDIT_ROOM_COMMAND:
                return new EditRoomCommand();
            case APPROVE_RESERVATION_COMMAND:
                return new ApproveReservationCommand();
            case DECLINE_RESERVATION_COMMAND:
                return new DeclineReservationCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }

    private CommandFactory() {
    }
}
