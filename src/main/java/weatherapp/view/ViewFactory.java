package weatherapp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import weatherapp.App;
import weatherapp.controller.BaseController;
import weatherapp.controller.CurrentWeatherController;
import java.io.IOException;

public class ViewFactory {


    public void showCurrentWeatherWindow(){
        System.out.println("Show current day weather");

        BaseController controller = new CurrentWeatherController("currentLocationWeatherWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController controller){

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("WeatherApp by Natalia Galicka");
        stage.show();
    }
}
