package com.victor.proyectofxfrontend.services;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public class ProyectoServices {
    private static final String BASE_URL = "http://localhost:8080/api/proyecto";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();


}
