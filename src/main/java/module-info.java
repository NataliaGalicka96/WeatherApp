module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens weatherapp.controller;
    opens weatherapp.view;
    opens weatherapp.css;

    exports weatherapp;
    opens weatherapp;
}