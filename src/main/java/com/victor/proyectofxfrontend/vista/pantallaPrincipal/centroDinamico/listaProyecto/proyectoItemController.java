package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class proyectoItemController {
    private Integer id;

    public void setId(Integer id){
        this.id = id;
    }

    @FXML
    private Label nombreLabel;

    @FXML
    private Label descripcionLabel;

    @FXML
    private Label fechaLabel;

    @FXML
    private void handleClick(){

    }
}
