module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens weatherapp to javafx.fxml;
    opens weatherapp.controller;
    opens weatherapp.model;
    opens weatherapp.css;
    exports weatherapp;
}