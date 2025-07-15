module com.victor.proyectofxfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.victor.proyectofxfrontend.vista.inicioDeSesion to javafx.fxml;
    exports com.victor.proyectofxfrontend;
}