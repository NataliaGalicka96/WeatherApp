module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires org.json;
	requires json.simple;

    opens weatherapp.controller;
    opens weatherapp.view;
    opens weatherapp.model;
    opens weatherapp.services;
   // opens weatherapp.css;
    
    exports weatherapp;
    opens weatherapp;
}