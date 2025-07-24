package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.moficiarPerfil;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import com.victor.proyectofxfrontend.utils.VerificarCorreo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarPerfilControler {
    @FXML
    private TextField nombreField;

    @FXML
    private TextField correoField;

    @FXML
    private Label usuarioLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private void guardarCambios() throws Exception{
        String nombre = nombreField.getText();
        String correo = correoField.getText();

        Usuario usuario1 = new Usuario();
        usuario1.setId(usuario.getId());
        usuario1.setNombre(nombre);

        if (!correo.isEmpty()){
            if (VerificarCorreo.esCorrectoValido(correo)){
                usuario1.setCorreo(correo);
            } else {
                errorLabel.setText("El correo no es valido");
            }
        }



        System.out.println(us.actualizarUsuario(usuario1));
        cancelar();
    }

    @FXML
    private void cancelar(){
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }

    private Integer id;

    private Usuario usuario;

    private UsuarioServices us = new UsuarioServices();

    public void setId(Integer id) throws Exception {
        this.id = id;
        usuario = us.getUsuario(id);
        usuarioLabel.setText("Usuario con id: " + usuario.getId());
    }
}
