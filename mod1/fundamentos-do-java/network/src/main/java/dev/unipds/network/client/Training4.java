package dev.unipds.network.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Training4 {
    
    public static void main(String[] args) throws Exception {
        URI uri = URI.create("https://viacep.com.br/ws/01001000/json/"); 
        
        
        try(HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder(uri).build();
            HttpResponse<String> httpResponse =  httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        
            int statusCode = httpResponse.statusCode();
            String body = httpResponse.body();
            
            System.out.println("StatusCode: " + statusCode);
            System.out.println("Body: " + body);
        }    
    }
}

