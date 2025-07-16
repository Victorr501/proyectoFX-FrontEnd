package com.victor.proyectofxfrontend.vista.registro;

import com.victor.proyectofxfrontend.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class registroController {
    @FXML private TextField usernameField;
    @FXML private TextField correoField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordFieldRepetir;
    @FXML private Label errorLabel;

    @FXML
    private void registrarse(){
        Usuario usuario = new Usuario();

        cerrarPestana();
    }

    @FXML
    private void cancelar(){
        cerrarPestana();
    }

    private void cerrarPestana(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/inicioDeSesion.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Registro de usuario");
            stage.setScene(new Scene(root));
            stage.show();

            Stage actual = (Stage) usernameField.getScene().getWindow();
            actual.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
