package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto.items;

import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.services.ProyectoServices;
import com.victor.proyectofxfrontend.vista.proyecto.ProyectoPrincipalController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    private void handleClick() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal/proyectoPantallaPrincipal/proyecctoPantallaPrincipal.fxml"));
        Parent root = loader.load();

        ProyectoPrincipalController pPC = loader.getController();
        pPC.setId(id);

        Stage nuevaVentana = (Stage) nombreLabel.getScene().getWindow();
        nuevaVentana.setTitle("Proyecto");
        nuevaVentana.setScene(new Scene(root));
        nuevaVentana.show();


    }
}
