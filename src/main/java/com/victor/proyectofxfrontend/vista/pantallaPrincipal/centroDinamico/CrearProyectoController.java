package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CrearProyectoController {
    private Integer id;

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
    private void handleCrearProyecto(){

    }
}
