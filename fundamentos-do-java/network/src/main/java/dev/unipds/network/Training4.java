package dev.unipds.network;

import java.net.*;
import java.net.http.*;
import java.io.*;
import java.util.*;

public class Training2 {
    
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

