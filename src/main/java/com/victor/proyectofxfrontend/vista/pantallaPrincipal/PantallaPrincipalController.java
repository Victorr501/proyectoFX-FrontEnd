package com.victor.proyectofxfrontend.vista.pantallaPrincipal;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PantallaPrincipalController {

    @FXML
    private ImageView userImage;
    @FXML
    private Label userNameLabel;


    private Usuario usuario;
    private UsuarioServices usuarioServices = new UsuarioServices();

    public void setUsuario(String correo){
        try {
            usuario = usuarioServices.getUsuario(correo);
        } catch (Exception e) {
            System.err.println("Error al cargar los datos");
        }
    }

    @FXML
    private void perfil(){

    }

}
