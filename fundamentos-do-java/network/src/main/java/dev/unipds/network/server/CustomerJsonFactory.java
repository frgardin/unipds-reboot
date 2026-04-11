package dev.unipds.network.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.FileSystems;

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
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*-customers.json");
        try (var stream = Files.list(Path.of("."))) {
            stream.filter(p -> matcher.matches(p.getFileName()))
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}