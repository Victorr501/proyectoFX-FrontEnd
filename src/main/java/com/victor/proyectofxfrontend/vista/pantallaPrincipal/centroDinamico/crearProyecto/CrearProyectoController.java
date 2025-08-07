package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.crearProyecto;

import com.victor.proyectofxfrontend.models.Documento;
import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.services.DocumentoServices;
import com.victor.proyectofxfrontend.services.ProyectoServices;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CrearProyectoController {
    //id de usuario
    private Integer id;

    private final ProyectoServices ps = new ProyectoServices();

    private final DocumentoServices dS = new DocumentoServices();

    public void setId(Integer id){
        this.id = id;
    }

    @FXML
    private Label labelError;

    @FXML
    private TextField nombreCampo;

    @FXML
    private TextArea descripcionCampo;

    @FXML
    private void handleCrearProyecto() throws Exception {
        String nombre = nombreCampo.getText().trim();
        String descripcion = descripcionCampo.getText().trim();

        if (nombre.isEmpty()){
            labelError.setText("El nombre no puede estar vacío");
            return;
        }

        if (descripcion.length() >= 1000){
            labelError.setText("El tamaño del la descripcion tiene que ser menor que 1000 caracteres");
            return;
        }

        Proyecto p = new Proyecto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);


        try {
            String respuesta = ps.crearProyecto(p, id);
            labelError.setText(respuesta);
            nombreCampo.clear();
            descripcionCampo.clear();
        } catch (Exception e){
            labelError.setText("Error al crear el proyecto: " + e.getMessage());
            System.out.println(e.getMessage());
        }

        Integer idProyecto =
        Documento d = new Documento();
        d.setTitulo(nombre);

        try {
            String respuesta = dS.
            labelError.setText();
        } catch (Exception e){
            labelError.setText("Error al crear el proyecto: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
