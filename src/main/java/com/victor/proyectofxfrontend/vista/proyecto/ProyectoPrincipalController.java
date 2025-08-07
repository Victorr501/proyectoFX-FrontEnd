package com.victor.proyectofxfrontend.vista.proyecto;

import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.services.ProyectoServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ProyectoPrincipalController {
    //id proyecto
    private Integer id;

    //id de usuario
    private Integer idUsuario;
    private Proyecto proyecto;
    private ProyectoServices proyectoServices = new ProyectoServices();

    public void setId(Integer id) throws Exception {
        this.id = id;
        proyecto = proyectoServices.getProyecto(id);
        idUsuario = proyecto.getIdUsuario();
    }

    @FXML
    StackPane panelCentral;

    @FXML
    Label usernameLabel;

    @FXML
    private void mostrarVista1(){

    }

    @FXML
    private void mostrarVista2(){

    }

    @FXML
    private void mostrarVista3(){

    }

    private void cargarVistaEnPanel(String ruta){
        try {
            Parent vista = FXMLLoader.load(getClass().getResource(ruta));
            panelCentral.getChildren().setAll(vista);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
