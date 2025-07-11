module com.victor.proyectofxfrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.victor.proyectofxfrontend to javafx.fxml;
    exports com.victor.proyectofxfrontend;
}