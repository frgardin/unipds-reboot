package dev.unipds.network;

import java.net.*;
import java.io.*;
import java.util.*;

public class Training2 {
    
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://viacep.com.br/ws/01001000/json/");
        
        InputStream inputStream = url.openStream();

        try(Scanner sc = new Scanner(inputStream)) { // scanner implements closeable
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}

