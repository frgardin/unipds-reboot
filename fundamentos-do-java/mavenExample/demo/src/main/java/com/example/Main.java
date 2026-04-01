package com.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Product p = new Product(12345, "Comnputador", 1500.0);

        Gson gson = new Gson();
        System.out.println(gson.toJson(p));
    }
}