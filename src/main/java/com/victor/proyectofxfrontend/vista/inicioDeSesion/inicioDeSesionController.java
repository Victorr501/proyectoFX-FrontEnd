package com.victor.proyectofxfrontend.vista.inicioDeSesion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class inicioDeSesionController {
     @FXML private TextField usernameField;
     @FXML private PasswordField passwordField;
     @FXML private Label errorLabel;

     @FXML
     private void handleLogin(){

     }

     @FXML
     private void handleRegister(){
          try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/registro.fxml"));
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
