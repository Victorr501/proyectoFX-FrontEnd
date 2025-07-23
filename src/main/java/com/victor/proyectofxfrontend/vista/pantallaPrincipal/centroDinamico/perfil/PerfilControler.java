package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import com.victor.proyectofxfrontend.utils.VerificarCorreo;
import com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.confirmarEliminar.ConfirmarEliminarController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PerfilControler {
    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private void editarUsuario(){

    }

    @FXML
    private void cabniarContraseña(){

    }

    @FXML
    private void eliminarCuenta() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal/confirmarEliminar/cofirmarEliminar.fxml"));
        AnchorPane root = loader.load();

        ConfirmarEliminarController cEC = loader.getController();
        cEC.setId(usuario.getId());
        cEC.setOnSuccess(() -> {
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/inicioDeSesion.fxml"));
            Parent loginRoot = null;
            try {
                loginRoot = loginLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = (Stage) usernameLabel.getScene().getWindow(); // Usa cualquier botón o nodo de la escena actual
            stage.setScene(new Scene(loginRoot));
            System.out.println("Cuenta eliminada. Cerrando sesión...");
        });

        Stage stage = new Stage();
        stage.setTitle("Confirmar eliminación");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }


    //id usuario
    private Integer id;

    private Usuario usuario;


    private UsuarioServices us = new UsuarioServices();

    public void getId(Integer id) throws Exception {
        this.id = id;
        usuario = us.getUsuario(id);
        usernameLabel.setText(usuario.getNombre());
        emailLabel.setText(usuario.getCorreo());
    }
}
