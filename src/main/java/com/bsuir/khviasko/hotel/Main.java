package com.bsuir.khviasko.hotel;

import com.bsuir.khviasko.hotel.connection.ConnectionManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    public static void main(String[] args) {
        System.out.println("Server starts");
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("New connection on IP-address: " + clientSocket.getInetAddress());
                Thread thread = new Thread(() -> {
                                    ConnectionManager service = new ConnectionManager();
                                    service.start(clientSocket);
                                }, "");
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
