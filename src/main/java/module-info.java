module com.victor.proyectofxfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires jakarta.mail;
    requires org.fxmisc.richtext;

    opens com.victor.proyectofxfrontend.models to com.google.gson;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.inicioDeSesion to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.registro to javafx.fxml;
    opens com.victor.proyectofxfrontend.models.complementos to com.google.gson;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto.items to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.crearProyecto to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.confirmarEliminar to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.moficiarPerfil to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.perfil.actualizarContrasena to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.proyecto to javafx.fxml;

    exports com.victor.proyectofxfrontend;
}