package com.bsuir.khviasko.hotel.command;

import com.bsuir.khviasko.hotel.command.impl.admin.AddUserCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.DeleteUserCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.EditReservationCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.ProfitReportCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.RoomDiagramCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.ViewReservationsCommand;
import com.bsuir.khviasko.hotel.command.impl.admin.ViewUsersCommand;
import com.bsuir.khviasko.hotel.command.impl.common.LoginCommand;
import com.bsuir.khviasko.hotel.command.impl.common.RegistrationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.EditUserInformationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ReservationsReportCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ReserveRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ResetReservationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.RoomPriceChartCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewRoomsCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewSingleRoomCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewUserInformationCommand;
import com.bsuir.khviasko.hotel.command.impl.user.ViewUserReservationsCommand;

public class CommandFactory {

    //common
    private static final String LOGIN_COMMAND = "login";
    private static final String REGISTRATION_COMMAND = "registration";

    //user
    private static final String VIEW_USER_COMMAND = "view_user";
    private static final String EDIT_USER_COMMAND = "edit_user";
    private static final String VIEW_ROOMS_COMMAND = "view_rooms";
    private static final String VIEW_SINGLE_ROOM_COMMAND = "view_single_room";
    private static final String RESERVE_ROOM_COMMAND = "reserve_room";
    private static final String RESET_RESERVATION_COMMAND = "reset_reservation";
    private static final String VIEW_USER_RESERVATIONS_COMMAND = "view_user_reservations";
    private static final String RESERVATION_REPORT_COMMAND = "reservation_report";
    private static final String ROOM_PRICE_CHART_COMMAND = "room_price_chart";

    //admin
    private static final String VIEW_USERS_COMMAND = "view_users";
    private static final String ADD_USER_COMMAND = "add_user";
    private static final String DELETE_USER_COMMAND = "delete_user";
    private static final String PROFIT_REPORT_COMMAND = "profit_report";
    private static final String ROOM_AVAILABILITY_DIAGRAM_COMMAND = "room_diagram";
    private static final String VIEW_RESERVATIONS_COMMAND = "view_reservations";
    private static final String EDIT_RESERVATION_STATUS_COMMAND = "edit_reservation";

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
            case RESERVATION_REPORT_COMMAND:
                return new ReservationsReportCommand();
            case ROOM_PRICE_CHART_COMMAND:
                return new RoomPriceChartCommand();
            case VIEW_USER_RESERVATIONS_COMMAND:
                return new ViewUserReservationsCommand();
            case VIEW_USERS_COMMAND:
                return new ViewUsersCommand();
            case ADD_USER_COMMAND:
                return new AddUserCommand();
            case DELETE_USER_COMMAND:
                return new DeleteUserCommand();
            case PROFIT_REPORT_COMMAND:
                return new ProfitReportCommand();
            case ROOM_AVAILABILITY_DIAGRAM_COMMAND:
                return new RoomDiagramCommand();
            case VIEW_RESERVATIONS_COMMAND:
                return new ViewReservationsCommand();
            case EDIT_RESERVATION_STATUS_COMMAND:
                return new EditReservationCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }

    private CommandFactory() {
    }
}
