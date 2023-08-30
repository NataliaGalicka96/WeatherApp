module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires org.json;
	requires json.simple;
	requires javafx.base;
	requires gson;
	requires java.sql;
	requires org.controlsfx.controls;
	requires owm.japis;
	requires com.fasterxml.jackson.databind;
	requires java.desktop;

    opens weatherapp.controller to javafx.fxml;
    opens weatherapp.view;
    opens weatherapp.model;
    
    exports weatherapp;
    opens weatherapp;


}