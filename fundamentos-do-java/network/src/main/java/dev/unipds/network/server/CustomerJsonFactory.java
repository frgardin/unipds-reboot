package dev.unipds.network.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.unipds.network.database.mock.DatabaseMock;

public class CustomerJsonFactory {

    public static Path createSampleJson() throws Exception {
        var database = new DatabaseMock(4);
        var customers = database.getCustomers();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(customers);

        Path path = Path.of("" + System.currentTimeMillis() + "-customers.json");
        Files.writeString(path, json);
        return path;
    }

    public static void deleteAll() throws IOException {
        try (var stream = Files.newDirectoryStream(Path.of("."), "*-customers.json")) {
            for (Path p : stream) {
                Files.delete(p);
            }
        }
    }
}