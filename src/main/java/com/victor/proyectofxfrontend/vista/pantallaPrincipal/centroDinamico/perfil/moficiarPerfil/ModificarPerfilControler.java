package com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.moficiarPerfil;

import com.victor.proyectofxfrontend.models.Usuario;
import com.victor.proyectofxfrontend.services.UsuarioServices;
import com.victor.proyectofxfrontend.utils.VerificarCorreo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarPerfilControler {
    @FXML
    private TextField nombreField;

    @FXML
    private TextField correoField;

    @FXML
    private void guardarCambios(){

    }

    @FXML
    private void cancelar(){
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }

    private Integer id;

    private Usuario usuario;

    private UsuarioServices us = new UsuarioServices();

    private VerificarCorreo vC = new VerificarCorreo();

    public void setId(Integer id) throws Exception {
        this.id = id;
        usuario = us.getUsuario(id);
    }
}
