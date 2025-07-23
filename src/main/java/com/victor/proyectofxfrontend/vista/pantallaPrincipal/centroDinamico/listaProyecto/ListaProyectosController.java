package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto;

import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.services.ProyectoServices;
import com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto.items.ProyectoItemController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.List;

public class ListaProyectosController {
    //id usuario
    private Integer id;

    public void setId(Integer id){
        this.id = id;
        crearProyecto();
    }

    private ProyectoServices ps = new ProyectoServices();

    @FXML
    private FlowPane contenedorProyectos;


    public void crearProyecto(){
        try {

            List<Proyecto> proyectos = ps.getProyectoPorIdUsuario(id);


            for (Proyecto proyecto : proyectos) {
                try {
                    System.out.println(proyecto.toString());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal/listaProyectos/proyectoItem.fxml"));
                    AnchorPane item = loader.load();

                    ProyectoItemController pic = loader.getController();
                    pic.setId(proyecto.getId());

                    contenedorProyectos.getChildren().add(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e){
            System.out.println("Error al cargar cargar usuarios");
            e.printStackTrace();
        }
    }
}
