package com.bsuir.khviasko.hotel.command;

import com.bsuir.khviasko.hotel.command.impl.LoginCommand;

import java.security.NoSuchAlgorithmException;

public class CommandFactory {
    private static final String LOGIN_COMMAND = "login";

    public static Command create(String сommandName){
        switch (сommandName) {
            case LOGIN_COMMAND:
                return new LoginCommand();
            default:
                throw new IllegalArgumentException("No such this command");
        }
    }
}
