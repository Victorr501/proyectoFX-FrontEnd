package com.victor.proyectofxfrontend.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.models.complementos.CrearProyecto;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ProyectoServices {
    private static final String BASE_URL = "http://localhost:8080/api/proyecto";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Proyecto getProyecto(Integer id) throws Exception{
        URI uri = new URI(BASE_URL+ "/" + id);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        if (response.statusCode() == 200){
            return gson.fromJson(body, Proyecto.class);
        } else {
            throw new RuntimeException("Error al obtener el proyecto:" + response.statusCode());
        }

    }

    public List<Proyecto> getProyectoPorIdUsuario(Integer id) throws Exception{
        URI uri = new URI(BASE_URL + "/usuario/" + id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        if (response.statusCode() == 200){
            Type listType = new TypeToken<List<Proyecto>>() {}.getType();
            return gson.fromJson(body, listType);
        }  else {
            throw new RuntimeException("Error al obtener los proyectos del usuario: código " + response.statusCode());
        }
    }

    public String crearProyecto(Proyecto proyecto, Integer id) throws Exception{
        CrearProyecto cp = new CrearProyecto(proyecto, id);
        String json = gson.toJson(cp);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+ "/crear"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }
}
