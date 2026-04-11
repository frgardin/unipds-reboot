package dev.unipds.network.server;


import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;

public class CustomerServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
        HttpServer httpServer = HttpServer.create(inetSocketAddress, 0);

        Path sampleJson = CustomerJsonFactory.createSampleJson();

        httpServer.createContext("/customers.json", exchange -> {
            String json = Files.readString(sampleJson);
            byte[] bytes = json.getBytes();

            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(bytes);
        });

        System.out.println("Http Server is running!");

        httpServer.start();
    }
}
