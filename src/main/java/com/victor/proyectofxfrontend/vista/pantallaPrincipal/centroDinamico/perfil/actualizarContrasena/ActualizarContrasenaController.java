package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.actualizarContrasena;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.models.complementos.CambiarContraseña;
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

        CambiarContraseña cC = new CambiarContraseña();

        if (newPassword.length() >= 6 && newPassword.equals(repitPassword)){
            cC.setCorreo(correo);
            cC.setActualPassword(passwordAntigua);
            cC.setNuevaPassword(newPassword);

            String resultado = uS.actualizarUsuarioContraseña(cC);
            System.out.println(resultado);

            cancelar();
        } else errorLabel.setText("La nueva contraseña es muy corta y o no coincide con las contraseñas");


    }

    private Integer id;

    private Usuario usuario;

    private UsuarioServices uS = new UsuarioServices();

    public void setId(Integer id) throws Exception {
        this.id = id;
        usuario = uS.getUsuario(id);
    }
}
