package dev.unipds.network.client;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Training1 {
    
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://viacep.com.br/ws/01001000/json/");
        
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

