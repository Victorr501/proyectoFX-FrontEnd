package com.victor.proyectofxfrontend.services;

import com.victor.proyectofxfrontend.models.Login;
import com.victor.proyectofxfrontend.models.Usuario;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

public class UsuarioServices {
    private static final String BASE_URL = "http://localhost:8080/api/usuario";
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    //Conseguir el usuairo por el corro, para el inicio de sesion
    public Usuario getUsuario(String correo) throws Exception{
        String encodedEmail = URLEncoder.encode(correo, StandardCharsets.UTF_8);
        URI uri = URI.create(BASE_URL + "/correo/" + encodedEmail);


        //Hacer la peticion al servidor
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int status = response.statusCode();
        String body = response.body();

        //Gestion de respuesta
        if (status == 200){
            return gson.fromJson(body, Usuario.class);
        } else if (status == 404){
            System.out.println("Usuario no encotroado con el correo: " + correo);
            return null;
        } else {
            throw new RuntimeException("Error al buscar usuario (" + status +"): " +body);
        }
    }

    public String registrar(Usuario usuario) throws Exception{
        try {
            //Pasar el usuario a json
            String json = gson.toJson(usuario);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL+"/registrar"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                return "Usuario registrado con éxito: ";
            } else {
                return "Error al registrar usuario: ";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Excepción al registrar usuario: " + e.getMessage();
        }
    }

    public String login(Login login) throws Exception{
        try {
            String json = gson.toJson(login);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL+"/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                return response.body();
            } else if (response.statusCode() == 401){
                return response.body();
            } else {
                return "Error en el login: " + response.statusCode() + " - " + response.body();
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Excepción al registrar usuario";
        }
    }
}
