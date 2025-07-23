package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    private void eliminarCuenta(){

    }


    //id usuario
    private Integer id;

    private Usuario usuario;

    private UsuarioServices us= new UsuarioServices();

    public void getId(Integer id) throws Exception {
        this.id = id;
        usuario = us.getUsuario(id);
        usernameLabel.setText(usuario.getNombre());
        emailLabel.setText(usuario.getCorreo());
    }
}
