package com.victor.proyectofxfrontend.vista.registro;

import com.victor.proyectofxfrontend.models.Usuario;
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

public class RegistroController {
    @FXML private TextField usernameField;
    @FXML private TextField correoField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordFieldRepetir;
    @FXML private Label errorLabel;

    private UsuarioServices uS = new UsuarioServices();

    @FXML
    private void registrarse(){
        Usuario usuario = new Usuario();
        usuario.setNombre(usernameField.getText());
        if (VerificarCorreo.esCorrectoValido(correoField.getText())){
            usuario.setCorreo(correoField.getText());
        } else {
            errorLabel.setText("Correo no valido");
            return;
        }

        if (passwordField.getText().equals(passwordFieldRepetir.getText())){
            if (passwordField.getText().length() >= 6) {
                usuario.setPasswordHaseada(passwordField.getText());
            } else {
                errorLabel.setText("La contraseña tiene que ser mas larga");
                return;
            }
        } else {
            errorLabel.setText("La contraseñasi tienen que coencidir");
            return;
        }
        usuario.setActivo(true);

        try {
            uS.registrar(usuario);
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/victor/proyectofxfrontend/pantallaPrincipal.fxml"));
            Parent root = loader.load();

            PantallaPrincipalController controller = loader.getController();
            controller.setUsuario(correoField.getText());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();

            Stage actual = (Stage) passwordField.getScene().getWindow();
            actual.close();
        } catch (Exception e){
            System.err.println("Error");
            e.printStackTrace();
        }

    }

    @FXML
    private void cancelar(){
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
