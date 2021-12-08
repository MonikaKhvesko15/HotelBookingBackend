package com.bsuir.khviasko.hotel;

import com.bsuir.khviasko.hotel.connection.StreamManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server has started");
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8080);
            serverSocket.setReuseAddress(true);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection IP: " + clientSocket.getInetAddress().getHostAddress());

                new Thread(() -> {
                    StreamManager manager = new StreamManager();
                    manager.start(clientSocket);
                }, "").start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
