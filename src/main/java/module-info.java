module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires org.json;
	requires json.simple;
	requires javafx.base;
	requires ipgeolocation;
	requires gson;
	requires java.sql;
	requires org.controlsfx.controls;
	requires owm.japis;
	

    opens weatherapp.controller to javafx.fxml;
    opens weatherapp.view;
    opens weatherapp.model;
    opens weatherapp.css;
    
    exports weatherapp;
    opens weatherapp;


}