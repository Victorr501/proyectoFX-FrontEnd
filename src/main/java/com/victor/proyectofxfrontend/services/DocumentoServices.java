package com.victor.proyectofxfrontend.services;

import com.google.gson.Gson;
import com.victor.proyectofxfrontend.models.Documento;
import com.victor.proyectofxfrontend.models.complementos.DocumentoCrear;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DocumentoServices {
    private static final String BASE_URL = "http://localhost:8080/api/documento";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public String crearDocumento(Documento documento, Integer id) throws Exception{
        DocumentoCrear dC = new DocumentoCrear();
        dC.setDocumento(documento);
        dC.setId_proyecto(id);
        String json = gson.toJson(dC);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+ "/crear"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
