package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class ListaProyectosController {
    private Integer id;

    public void setId(Integer id){
        this.id = id;
    }

    @FXML
    private FlowPane contenedorProyectos;

    @FXML
    public void initialize(){

    }
}
