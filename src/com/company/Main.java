package com.company;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 1; i < Math.random()*7+2; i++) {
            clients.add(new Client("Client" + i));
        }
        for (Client client : clients){
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                client.run();
                executor.shutdown();
            });
        }

    }
}