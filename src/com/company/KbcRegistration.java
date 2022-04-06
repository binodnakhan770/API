package com.company;

import jdk.jfr.ContentType;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.login.CredentialException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class KbcRegistration {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*Payload create for parameters*/
        String payload = """
                data ={
                      "transferTypeId": "41",
                      "amount": "1",
                      "description": "ok",
                      "currencyId": "1",
                      "webRequest": true,
                      "customValues": [
                          {
                              "internalName": "PAYMENTMETHOD",
                              "fieldId": "15",
                              "value": "Account"
                          },
                          {
                              "internalName": "SELECTBANK",
                              "fieldId": "35",
                              "value": "NIBL"
                          },
                          {
                              "internalName": "ACCOUNTNUMBER",
                              "fieldId": "14",
                              "value": "001NMBTEST"
                          },
                          {
                              "internalName": "MOBILENUMBER",
                              "fieldId": "16",
                              "value": "8800000238"
                          }
                      ]
                  }
               
                """;
        HttpClient client = HttpClient.newBuilder().build();
        
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .header("accept","application/json")
                .header("9860876238","123456")
                .uri(URI.create("https://test.cellpay.com.np/rest/access/login"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


    }
}
