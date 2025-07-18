package com.victor.proyectofxfrontend.vista.inicioDeSesion;

import com.victor.proyectofxfrontend.models.complementos.Login;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import com.victor.proyectofxfrontend.utils.VerificarCorreo;
import com.victor.proyectofxfrontend.vista.pantallaPrincipal.PantallaPrincipalController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioDeSesionController {
     @FXML private TextField userCorreoField;
     @FXML private PasswordField passwordField;
     @FXML private Label errorLabel;

     private UsuarioServices uS = new UsuarioServices();

     @FXML
     private void handleLogin(){
          Login login = new Login();
          String correo = userCorreoField.getText();
          String password = passwordField.getText();
          if (correo.isEmpty() || password.isEmpty()) {
               errorLabel.setText("Complete los campos");
               return;
          }

          if (VerificarCorreo.esCorrectoValido(correo)){
               login.setCorreo(correo);
               login.setContrasena(password);
          } else {
               errorLabel.setText("Introduzca un correo valido");
               return;
          }

         try {
             String respuesta = uS.login(login);
             if (respuesta.equals("Login correcto")){
                  abrirPantallaPrincipal(correo);
             } else {
                  errorLabel.setText(respuesta);
             }
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
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

               Stage actual = (Stage) userCorreoField.getScene().getWindow();
               actual.close();
          } catch (IOException e){
               e.printStackTrace();
          }
     }

     private void abrirPantallaPrincipal(String correo) throws Exception{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal.fxml"));
          Parent root = loader.load();

          PantallaPrincipalController controller = loader.getController();
          controller.setUsuario(correo);

          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.setTitle("Dashboard");
          stage.show();

          Stage actual = (Stage) passwordField.getScene().getWindow();
          actual.close();
     }
}
