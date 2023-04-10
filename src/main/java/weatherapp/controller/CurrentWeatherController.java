package weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import weatherapp.Config;
import weatherapp.model.WeatherManager;
import weatherapp.view.ViewFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class CurrentWeatherController extends BaseController implements Initializable{

	 @FXML
	    private VBox body;

	    @FXML
	    private TextField chooseLocation;

	    @FXML
	    private TextField chooseLocation1;

	    @FXML
	    private Label currentCity;

	    @FXML
	    private Label currentCity1;

	    @FXML
	    private Label currentDate;

	    @FXML
	    private Label currentDate1;

	    @FXML
	    private Label currentDegree11;

	    @FXML
	    private Label currentDegree111;

	    @FXML
	    private Label currentHumidity;

	    @FXML
	    private Label currentHumidity1;

	    @FXML
	    private ImageView currentPicture1;

	    @FXML
	    private ImageView currentPicture11;

	    @FXML
	    private Label currentPressure2;

	    @FXML
	    private Label currentPressure21;

	    @FXML
	    private Label currentWindSpeed;

	    @FXML
	    private Label currentWindSpeed1;

	    @FXML
	    private Label description;

	    @FXML
	    private Label description1;

	    @FXML
	    private VBox hboxNew;

	    @FXML
	    private VBox hboxNew1;

	    @FXML
	    private Label sensedTemperature;

	    @FXML
	    private Label sensedTemperature1;

	    @FXML
	    private HBox weatherNextDay;
	    
	    @FXML
	    private HBox hboxNextDayWeather;

	    @FXML
	    private HBox hboxNextDayWeather1;
	    
	    @FXML
	    private VBox vbox1;

	    @FXML
	    private VBox vbox2;

	    @FXML
	    private VBox vbox3;

	    @FXML
	    private VBox vbox4;

    
	    public CurrentWeatherController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
	        super(weatherManager, viewFactory, fxmlName);
	    }
    
    @FXML
    void getLocation(ActionEvent event) throws IOException {
    	
    	hboxNextDayWeather.getChildren().clear();
    	
    	String cityName = "Londyn";
    	
    	String YOUR_API_KEY = Config.API_KEY;
    	
    	String UNIT_GROUP = Config.UNIT_GROUP;
    	
    	String CONTENT_TYPE = Config.CONTENT_TYPE;
    	
    	String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";
    	
    	
    	WeatherManager weatherManager = new WeatherManager(url);
    	

    	weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
    			currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentWindSpeed, description,
sensedTemperature, weatherNextDay, hboxNextDayWeather);
     	
    }    
    

	public void initialize(URL location, ResourceBundle resources) {
		
/*
 * W tym miejscu pobrać dane obecnej lokalizacji użytkownika
 */
		String cityName = "Izabelin";
    	
    	String YOUR_API_KEY = Config.API_KEY;
    	
    	String UNIT_GROUP = Config.UNIT_GROUP;
    	
    	String CONTENT_TYPE = Config.CONTENT_TYPE;
    	
    	String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";
    	
    	DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        dropShadow.setWidth(40);
        dropShadow.setHeight(40);
        dropShadow.setRadius(19.5);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(00);
        dropShadow.setColor(Color.color(0, 0, 0));
        hboxNew.setEffect(dropShadow);
        hboxNew1.setEffect(dropShadow);
        hboxNextDayWeather.setEffect(dropShadow);
        hboxNextDayWeather1.setEffect(dropShadow);
        
		WeatherManager weatherManager = new WeatherManager(url);
    	
				weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
						currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentWindSpeed, description,
sensedTemperature, weatherNextDay,hboxNextDayWeather);

	
	}
}
