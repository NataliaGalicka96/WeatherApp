package weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import weatherapp.model.Location;
import weatherapp.model.WeatherManager;
import weatherapp.services.LocationService;
import weatherapp.view.ViewFactory;
import weatherapp.Config;
import weatherapp.model.APIConnector;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


import org.json.JSONArray;
import org.json.JSONObject;



public class CurrentWeatherController extends BaseController{

    @FXML
    private VBox body;
    
    @FXML
    private TextField chooseLocation;

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
    private Label nextDayName;

    @FXML
    private Label nextDayName1;

    @FXML
    private Label nextDayName11;

    @FXML
    private Label nextDayName111;

    @FXML
    private Label nextDayName1111;

    @FXML
    private ImageView pictureNextDay;

    @FXML
    private ImageView pictureNextDay1;

    @FXML
    private ImageView pictureNextDay11;

    @FXML
    private ImageView pictureNextDay111;

    @FXML
    private ImageView pictureNextDay1111;

    @FXML
    private Label sensedTemperature;

    @FXML
    private Label temperatureNextDay;

    @FXML
    private Label temperatureNextDay1;

    @FXML
    private Label temperatureNextDay11;

    @FXML
    private Label temperatureNextDay111;

    @FXML
    private Label temperatureNextDay1111;

    @FXML
    private Label temperatureNextNight;

    @FXML
    private Label temperatureNextNight1;

    @FXML
    private Label temperatureNextNight11;

    @FXML
    private Label temperatureNextNight111;

    @FXML
    private Label temperatureNextNight1111;
    
    @FXML
    void getLocation(ActionEvent event) throws IOException {
    	
    	WeatherManager weatherManager = new WeatherManager();
    	
    	weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
    			currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentTime, currentWindSpeed, description,
sensedTemperature);
    	
    }
     
    

    public CurrentWeatherController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }
}
