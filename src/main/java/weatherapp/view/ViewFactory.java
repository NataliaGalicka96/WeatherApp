package weatherapp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import weatherapp.App;
import weatherapp.WeatherManager;
import weatherapp.controller.BaseController;
import weatherapp.controller.MainWindowController;


import java.io.IOException;

public class ViewFactory {

    private WeatherManager weatherManager;

    public ViewFactory(WeatherManager weatherManager){
        this.weatherManager = weatherManager;
    }

    public void showMainWindow(){
        System.out.println("Show main window controller");

        BaseController controller = new MainWindowController(weatherManager, this, "mainWindow.fxml");
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
        stage.show();
    }
}
