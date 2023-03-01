module weatherapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens weatherapp to javafx.fxml;
    exports weatherapp;
}