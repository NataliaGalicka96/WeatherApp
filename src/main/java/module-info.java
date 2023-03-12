module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens weatherapp.controller;
    opens weatherapp.view;
    opens weatherapp.model;
   // opens weatherapp.css;
    
    exports weatherapp;
    opens weatherapp;
}