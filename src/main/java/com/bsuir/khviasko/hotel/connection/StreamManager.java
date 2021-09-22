package com.bsuir.khviasko.hotel.connection;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class StreamManager {
    public void start(Socket socket) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.flush();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                process(bufferedWriter, bufferedReader);
            }
        } catch (Exception e) {
            System.out.println("Server connection error");
        }
    }

    private void process(BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException {
//        ClientDao clientDao = new ClientDao();
//        OrderDao orderDao = new OrderDao();
//        AdminDao adminDao = new AdminDao();
        Gson gson = new Gson();
        String query = bufferedReader.readLine();
        //String  = gson.fromJson();
//        switch (queryDTO.getQuery()) {
//            case ("signIn"): {
//            }
//        }
    }
}
