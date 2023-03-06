module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens weatherapp to javafx.fxml;
    opens weatherapp.controller;
    exports weatherapp;
}