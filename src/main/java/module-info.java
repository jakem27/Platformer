module com.example.platformer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.platformer to javafx.fxml;
    exports com.example.platformer;

    opens com.example.platformer.controller to javafx.fxml;
    exports com.example.platformer.controller;

    exports com.example.platformer.model;
    opens com.example.platformer.model to javafx.fxml;

    exports com.example.platformer.util;
    opens com.example.platformer.util to javafx.fxml;
}