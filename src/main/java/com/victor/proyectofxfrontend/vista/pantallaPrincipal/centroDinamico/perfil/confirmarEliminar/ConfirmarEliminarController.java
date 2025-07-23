package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.confirmarEliminar;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.models.complementos.Login;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ConfirmarEliminarController {
    private Integer id;

    private Usuario usuario;

    private Runnable runnable;

    private UsuarioServices us = new UsuarioServices();

    public void setId(Integer id) throws Exception {
        this.id = id;
        usuario = us.getUsuario(id);
    }

    public void setOnSuccess(Runnable onSuccess){
        this.runnable = onSuccess ;
    }

    @FXML
    private PasswordField passwordField;

    @FXML
    private void cancelar(){
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmarEliminar(){
        try {
            String contraseña = passwordField.getText();
            String correo = usuario.getCorreo();
            Login login = new Login(correo, contraseña);

            String resultado = us.login(login);

            if (resultado.equals("Login correcto")){
                String respuesta = us.eliminarUsuario(usuario.getId());
                if (respuesta.equals("Usuario eliminado correctamente")){
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        System.err.println("Runnable no seteado");
                    }
                    cancelar();
                }else {
                    mostarAlerta("Error", "No se pudo eliminar la cuenta");
                }
            } else {
                mostarAlerta("Contraseña incorrecta", "La contraseña no coincide");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void mostarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
