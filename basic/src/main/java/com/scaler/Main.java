package com.scaler;

import com.scaler.greet.Greet;
import com.scaler.http.Client;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Greet greet = new Greet();
        System.out.println(greet.getGreetMessage());

        Client client = new Client();

        String response = client.get("https://example.com");
        System.out.println(response);
    }
}