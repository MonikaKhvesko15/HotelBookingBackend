package com.bsuir.khviasko.hotel.command;

import com.bsuir.khviasko.hotel.command.impl.common.LoginCommand;
import com.bsuir.khviasko.hotel.command.impl.common.LogoutCommand;
import com.bsuir.khviasko.hotel.command.impl.common.RegistrationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.EditUserInformationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ReservationsReportCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ReserveRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ResetReservationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.RoomPriceChartCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewReservationsCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewRoomsCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewSingleRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewUserInformationCommand;

public class CommandFactory {

    //common
    private static final String LOGIN_COMMAND = "login";
    private static final String REGISTRATION_COMMAND = "registration";
    private static final String LOGOUT_COMMAND = "logout";

    //user
    private static final String VIEW_USER_COMMAND = "view_user";
    private static final String EDIT_USER_COMMAND = "edit_user";

    private static final String VIEW_ROOMS_COMMAND = "view_rooms";
    private static final String VIEW_SINGLE_ROOM_COMMAND = "view_single_room";

    private static final String RESERVE_ROOM_COMMAND = "reserve_room";
    private static final String RESET_RESERVATION_COMMAND = "reset_reservation";
    private static final String RESERVATION_REPORT_COMMAND = "reservation_report";
    private static final String ROOM_PRICE_CHART_COMMAND = "room_price_chart";
    private static final String VIEW_RESERVATIONS_COMMAND = "view_reservations";

    //admin


    public static Command create(String сommandName) {
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            case REGISTRATION_COMMAND:
                return new RegistrationCommand();
            case LOGOUT_COMMAND:
                return new LogoutCommand();
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
            case RESERVATION_REPORT_COMMAND:
                return new ReservationsReportCommand();
            case ROOM_PRICE_CHART_COMMAND:
                return new RoomPriceChartCommand();
            case VIEW_RESERVATIONS_COMMAND:
                return new ViewReservationsCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }

    private CommandFactory() {
    }
}
