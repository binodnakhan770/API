package com.company;

import jdk.jfr.ContentType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class KbcRegistration {

    private static final String KBC_REGISTRATION_API_URI = "http://devapi.thedoko.com/api/kbc-registration";

    public static void main(String[] args) throws IOException, InterruptedException {

        /*Payload create for parameters*/
        String payload = """
                data ={
                     "fullName": "Binod Nakhan",
                     "email": "binod@gmail.com",
                     "phone": "9860876238",
                     "countryCode": "+977",
                     "quantity": 100
                 }
               
                """;
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .header("accept","application/json")
                .uri(URI.create(KBC_REGISTRATION_API_URI))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


    }
}
