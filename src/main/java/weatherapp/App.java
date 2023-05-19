package weatherapp;

import javafx.application.Application;
import javafx.stage.Stage;
import weatherapp.view.ViewFactory;


public class App extends Application {
	
	public static void main(String[] args) {
        launch();
    }
	
    @Override
    public void start(Stage stage) throws Exception{
    	//String url = "";
       // ViewFactory viewFactory = new ViewFactory(new WeatherManager(url));
    	ViewFactory viewFactory = new ViewFactory();
        viewFactory.showCurrentWeatherWindow();
    }

    
}