package dev.unipds.network;

import java.net.*;
import java.io.*;
import java.util.*;

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

