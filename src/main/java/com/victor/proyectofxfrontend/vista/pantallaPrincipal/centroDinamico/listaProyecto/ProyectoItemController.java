package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto;

import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.services.ProyectoServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;

public class ProyectoItemController {
    //id del proyecto
    private Integer id;

    private Proyecto proyecto;

    private ProyectoServices ps = new ProyectoServices();

    public void setId(Integer id){
        this.id = id;
        try {
            this.proyecto = ps.getProyecto(id);
        } catch (Exception e) {
            System.err.println("Error al cargar el proyecto");
            e.printStackTrace();
        }

        nombreLabel.setText(proyecto.getNombre());
        descripcionLabel.setText(proyecto.getDescripcion());
        fechaLabel.setText(proyecto.getFechaCreacion());
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
