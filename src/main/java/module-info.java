module com.victor.proyectofxfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires jakarta.mail;

    opens com.victor.proyectofxfrontend.models to com.google.gson;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.pantallaPrincipal.centroDinamico.listaProyecto to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.inicioDeSesion to javafx.fxml;
    opens com.victor.proyectofxfrontend.vista.registro to javafx.fxml;
    exports com.victor.proyectofxfrontend;
    opens com.victor.proyectofxfrontend.models.complementos to com.google.gson;
}