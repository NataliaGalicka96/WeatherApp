package weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import weatherapp.model.WeatherManager;
import weatherapp.view.ViewFactory;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory(new WeatherManager());
        viewFactory.showMainWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}