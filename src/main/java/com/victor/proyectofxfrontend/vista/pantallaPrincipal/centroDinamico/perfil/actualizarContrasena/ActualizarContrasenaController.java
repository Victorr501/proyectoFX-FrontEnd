package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.actualizarContrasena;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.models.complementos.Login;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ActualizarContrasenaController {
    @FXML
    private PasswordField passwordActual;

    @FXML
    private PasswordField nuevaPassword;

    @FXML
    private PasswordField repetirPassword;

    @FXML
    private Label errorLabel;

    @FXML
    private void cancelar(){
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void actualizar() throws Exception{
        String passwordAntigua = passwordActual.getText();
        String correo = usuario.getCorreo();
        String newPassword = nuevaPassword.getText();
        String repitPassword = repetirPassword.getText();

        Login login = new Login(correo, passwordAntigua);



        if (uS.login(login).equals("Login correcto")){
            if (newPassword.length() >= 6){
                if (newPassword.equals(repitPassword)){

                } else errorLabel.setText("Las contraseñas no coinciden");
            } else errorLabel.setText("La nueva contraseña es muy corta");
        } else errorLabel.setText("La contraseña no es correcta");

    }

    private Integer id;

    private Usuario usuario;

    private UsuarioServices uS = new UsuarioServices();

    public void setId(Integer id) throws Exception {
        this.id = id;
        usuario = uS.getUsuario(id);
    }
}
