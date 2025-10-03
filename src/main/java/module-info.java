module com.example.platformer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.platformer to javafx.fxml;
    exports com.example.platformer;
    exports com.example.platformer.controller;
    opens com.example.platformer.controller to javafx.fxml;
    exports com.example.platformer.util;
    opens com.example.platformer.util to javafx.fxml;
}