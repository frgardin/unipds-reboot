package dev.unipds.network.server;

import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

import dev.unipds.network.database.mock.DatabaseMock;

public class CustomerJsonFactory {

    public static void main(String[] args) throws Exception {
        var database = new DatabaseMock(4);
        var customers = database.getCustomers();

        Gson gson = new Gson();
        String json = gson.toJson(customers);
        
        Path path = Path.of("" + System.currentTimeMillis() + "-customers.json");
        Files.writeString(path, json);
    }
}
