package com.zullid.convertrail.api;

import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;

public class ApiController {

    public static void GetJsonData(String serviceUrl) {
        /*try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serviceUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                System.out.println(response.body());
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("GET");
    }

    public static void PostJsonData(String serviceUrl, String jsonData) throws IOException, InterruptedException {
        /*try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serviceUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                System.out.println(response.body());
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("POST");
    }

    public static void PutJsonData(String serviceUrl, String jsonData) {
        /* try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serviceUrl))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonData))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                System.out.println(response.body());
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("PUT");
    }

    public static void DeleteJsonData(String serviceUrl) {
        /* try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serviceUrl))
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                System.out.println("Eliminado exitosamente");
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("DELETE");
    }

}
