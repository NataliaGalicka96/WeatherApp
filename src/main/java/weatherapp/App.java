package weatherapp;

import javafx.application.Application;
import javafx.stage.Stage;
import weatherapp.view.ViewFactory;

import java.io.IOException;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        ViewFactory viewFactory = new ViewFactory(new WeatherManager());
        viewFactory.showMainWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}