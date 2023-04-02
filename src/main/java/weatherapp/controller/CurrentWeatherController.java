package weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import weatherapp.Config;
import weatherapp.model.WeatherManager;
import weatherapp.view.ViewFactory;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class CurrentWeatherController extends BaseController implements Initializable{


    
    @FXML
    private VBox body;

    @FXML
    private TextField chooseLocation;

    @FXML
    private ListView<?> cityList;

    @FXML
    private Label currentCity;

    @FXML
    private Label currentDate;

    @FXML
    private Label currentDegree11;

    @FXML
    private Label currentHumidity;

    @FXML
    private ImageView currentPicture1;

    @FXML
    private Label currentPressure2;

    @FXML
    private Label currentTime;

    @FXML
    private Label currentWindSpeed;

    @FXML
    private Label description;

    @FXML
    private Label sensedTemperature;

    @FXML
    private HBox weatherNextDay;

    
    String[] cities = {"Izabelin","Truskaw","Warszawa","Londyn"};
    
    String currentLocation;
    
    @FXML
    void getLocation(ActionEvent event) throws IOException {
    	
    	String cityName = "Truskaw";
    	
    	String YOUR_API_KEY = Config.API_KEY;
    	
    	String UNIT_GROUP = Config.UNIT_GROUP;
    	
    	String CONTENT_TYPE = Config.CONTENT_TYPE;
    	
    	String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";
    	
    	
    	WeatherManager weatherManager = new WeatherManager(url);
    	

    	weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
    			currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentTime, currentWindSpeed, description,
sensedTemperature, weatherNextDay);
     	
    }    
    

    public CurrentWeatherController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }




	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		/*
		cityList.getItems().addAll(cities);
		
		cityList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				currentLocation = cityList.getSelectionModel().getSelectedItem();
				
				System.out.println(currentLocation);
				
				chooseLocation.setText(currentLocation);
				
				WeatherManager weatherManager = new WeatherManager();
				
				
				weatherManager.setCityName(currentLocation);
				
		    	
		    	weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
		    			currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentTime, currentWindSpeed, description,
		sensedTemperature);
				
			}	
			});
			*/
		
		
		String cityName = "Izabelin";
    	
    	String YOUR_API_KEY = Config.API_KEY;
    	
    	String UNIT_GROUP = Config.UNIT_GROUP;
    	
    	String CONTENT_TYPE = Config.CONTENT_TYPE;
    	
    	String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";
    	
		
		WeatherManager weatherManager = new WeatherManager(url);
    	

	    	weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
	    			currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentTime, currentWindSpeed, description,
	sensedTemperature, weatherNextDay);
	
	}
}
