package dev.unipds.network.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomerSocketServer {

    public static void main(String[] args) throws Exception {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                System.out.println("Socker server is running!");
                try (Socket clientSocket = serverSocket.accept()) {
                    InputStream clientIS = clientSocket.getInputStream();
                    StringBuilder requestBuilder = new StringBuilder();
                    int data;

                    do {
                        data = clientIS.read();
                        requestBuilder.append((char) data);
                    } while (clientIS.available() > 0);

                    String request = requestBuilder.toString();
                    System.out.println(request);

                    Path sampleJson = CustomerJsonFactory.createSampleJson();

                    String json = Files.readString(sampleJson);

                    OutputStream clientOS = clientSocket.getOutputStream();
                    PrintStream clientOut = new PrintStream(clientOS);
                    clientOut.println("HTTP/1.1 200 OK");
                    clientOut.println("Content-type: application/json; charset=UTF-8");
                    clientOut.println();
                    clientOut.println(json);
                    CustomerJsonFactory.deleteAll();
                }
            }
        }
    }
}
