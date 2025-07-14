module com.victor.proyectofxfrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.victor.proyectofxfrontend.vista.inicioDeSesion to javafx.fxml;
    exports com.victor.proyectofxfrontend;
}