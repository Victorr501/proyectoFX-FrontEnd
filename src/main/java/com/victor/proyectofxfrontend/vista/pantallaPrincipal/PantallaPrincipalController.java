package com.victor.proyectofxfrontend.vista.pantallaPrincipal;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.CrearProyectoController;
import com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.ListaProyectosController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class PantallaPrincipalController {

    @FXML
    private Label userNameLabel;

    @FXML
    private StackPane contenidoCentro;


    private Usuario usuario;
    private UsuarioServices usuarioServices = new UsuarioServices();

    public void setUsuario(String correo){
        try {
            usuario = usuarioServices.getUsuario(correo);
            userNameLabel.setText(usuario.getNombre());
        } catch (Exception e) {
            System.err.println("Error al cargar los datos");
        }
    }

    @FXML
    private void perfil(){

    }

    @FXML
    private void mostarProyectos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal/listaProyectos.fxml"));
            Parent vistaCrear = loader.load();

            ListaProyectosController lPC = loader.getController();
            lPC.setId(usuario.getId());

            contenidoCentro.getChildren().setAll(vistaCrear);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void mostrarCrearProyecto(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal/crearProyecto.fxml"));
            Parent vistaCrear = loader.load();

            CrearProyectoController cPC = loader.getController();
            cPC.setId(usuario.getId());

            contenidoCentro.getChildren().setAll(vistaCrear);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
