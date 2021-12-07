package com.bsuir.khviasko.hotel;

import com.bsuir.khviasko.hotel.connection.StreamManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server has started");
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            server.setReuseAddress(true);

            while (true) {
                Socket client = server.accept();
                System.out.println("New connection IP: " + client.getInetAddress().getHostAddress());

                Thread thread = new Thread(() -> {
                                    StreamManager manager = new StreamManager();
                                    manager.start(client);
                                }, "");
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
