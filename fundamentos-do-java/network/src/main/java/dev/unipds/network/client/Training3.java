package dev.unipds.network.client;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Training3 {
    
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

