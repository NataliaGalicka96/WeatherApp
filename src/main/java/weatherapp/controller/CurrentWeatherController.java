package weatherapp.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import weatherapp.model.City;
import weatherapp.model.CityHandler;
import weatherapp.model.DailyWeatherConditions;
import weatherapp.model.HourlyWeatherConditions;
import weatherapp.model.OWMWeather;
import weatherapp.model.WeatherManager;

public class CurrentWeatherController extends BaseController implements Initializable{

	 	@FXML
	    private VBox body;

	    @FXML
	    private TextField chooseCurrentLocation;

	    @FXML
	    private TextField chooseDesiredLocation;

	    @FXML
	    private Label currentCityName;

	    @FXML
	    private Label currentDegree;

	    @FXML
	    private Label currentDescription;

	    @FXML
	    private Label currentHumidity;

	    @FXML
	    private ImageView currentIcon;

	    @FXML
	    private Label currentPressure;

	    @FXML
	    private Label currentWindSpeed;

	    @FXML
	    private ScrollPane dailyCurrentLocationWeather;

	    @FXML
	    private ScrollPane dailyDesiredLocationWeather;

	    @FXML
	    private Label desiredCityName;

	    @FXML
	    private Label desiredDegree;

	    @FXML
	    private Label desiredDescription;

	    @FXML
	    private Label desiredHumidity;

	    @FXML
	    private ImageView desiredIcon;

	    @FXML
	    private Label desiredPressure;

	    @FXML
	    private Label desiredWindSpeed;

	    @FXML
	    private ScrollPane hourlyCurrentLocationWeather;

	    @FXML
	    private ScrollPane hourlyDesiredLocationWeather;
	    
	    @FXML
	    private GridPane currentWeather;
	    
	    @FXML
	    private GridPane desiredWeather;
	    

	    public CurrentWeatherController(String fxmlName) { 
	        super(fxmlName);
	    }
	    
		OWMWeather owm = new OWMWeather();
		
		
		public void initialize(URL location, ResourceBundle resources) {

			 CityHandler cityProvider = new CityHandler();
			 cityProvider.getCityListFromJsonFile(chooseCurrentLocation);
			 cityProvider.getCityListFromJsonFile(chooseDesiredLocation);

			String city = "Izabelin";
			
			CurrentWeather cwd;
			
			try {
				
				cwd = owm.getCurrentWeather(city);
				
				WeatherManager weatherManager = new WeatherManager();
		    	
				weatherManager.getWeatherData(chooseCurrentLocation, currentCityName,
						currentDegree,currentHumidity, currentIcon, currentPressure, currentWindSpeed, currentDescription, cwd);
	
					/*
					if (!weatherManager.fetchDailyWeatherForecast(city).isEmpty()) {
					        setUpExtendedForecastView(weatherManager, dailyCurrentLocationWeather, city);
					    } else {
					   System.out.println("Błąd");
					    }
					

					if (!weatherManager.fetchHourlyWeatherForecast(city).isEmpty()) {
						setUpHourlyForecastContainer(weatherManager, hourlyCurrentLocationWeather, city);
					    } else {
					   System.out.println("Błąd");
					    }
					 */
					dailyCurrentLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
					hourlyCurrentLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
					Label currentLabel = new Label("Wybierz miasto, aby zobaczyć prognozę pogody");
					hourlyCurrentLocationWeather.setContent(currentLabel);
					
					dailyDesiredLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
					hourlyDesiredLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
					Label desiredLabel = new Label("Wybierz miasto, aby zobaczyć prognozę pogody");
					hourlyDesiredLocationWeather.setContent(desiredLabel);
					
			} catch (APIException e) {
				
				e.printStackTrace();
			}
	}
		
	    @FXML
	    void getDesiredLocation(ActionEvent event) {
	    	
	    	String city = chooseDesiredLocation.getText();
	    	
			try {
				CurrentWeather cwd = owm.getCurrentWeather(city);
				
				WeatherManager weatherManager = new WeatherManager();
		    	
				weatherManager.getWeatherData(chooseDesiredLocation, desiredCityName,
						desiredDegree,desiredHumidity, desiredIcon, desiredPressure, desiredWindSpeed, desiredDescription, cwd);


					if (!weatherManager.fetchDailyWeatherForecast(city).isEmpty()) {
					        setUpExtendedForecastView(weatherManager, dailyDesiredLocationWeather, city);
					    } else {
					   System.out.println("Brak danych dla tego miasta");
					    }
					
		
					if (!weatherManager.fetchHourlyWeatherForecast(city).isEmpty()) {
						setUpHourlyForecastContainer(weatherManager, hourlyDesiredLocationWeather, city);
					    } else {
					   System.out.println("Brak danych dla tego miasta");
					    }
						
			} catch (APIException e) {

				e.printStackTrace();
			}

	    }

	    @FXML
	    void getCurrentLocation(ActionEvent event) {
	    	
	    	String city = chooseCurrentLocation.getText();
	    	
	    	System.out.println(city);
	    	
	    	
			try {
				CurrentWeather cwd = owm.getCurrentWeather(city);
				
				WeatherManager weatherManager = new WeatherManager();
		    	
				weatherManager.getWeatherData(chooseCurrentLocation, currentCityName,
						currentDegree,currentHumidity, currentIcon, currentPressure, currentWindSpeed, currentDescription, cwd);


					if (!weatherManager.fetchDailyWeatherForecast(city).isEmpty()) {
					        setUpExtendedForecastView(weatherManager, dailyCurrentLocationWeather, city);
					    } else {
					    	 System.out.println("Brak danych dla tego miasta");
					    }
					
		
					if (!weatherManager.fetchHourlyWeatherForecast(city).isEmpty()) {
						setUpHourlyForecastContainer(weatherManager, hourlyCurrentLocationWeather, city);
					    } else {
					    	 System.out.println("Brak danych dla tego miasta");
					    }
						
			} catch (APIException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    }
  

	
	private void setUpExtendedForecastView(WeatherManager weatherManager, ScrollPane sp, String cityName) throws APIException {
			
			HBox hbox = new HBox();
			
	        for (DailyWeatherConditions dailyWeatherConditions : weatherManager.fetchDailyWeatherForecast(cityName)) {
	           
	        	VBox dayVBox = new VBox();
	
	            Label dateLabel = new Label(dailyWeatherConditions.getDateToDailyForecast());
	            dateLabel.setStyle("-fx-font-size: 15px;");
	
	
	            Label temperatureLabel = new Label(dailyWeatherConditions.getTemperature());
	            Label pressureLabel = new Label(dailyWeatherConditions.getPressure());
	             
	            Image icon = new Image(dailyWeatherConditions.getIconUrl());
	            ImageView imageView = new ImageView(icon);
	           
	            dayVBox.getChildren().addAll(
	                    dateLabel,
	                    imageView,
	                    temperatureLabel,
	                    pressureLabel
	            );
	           
	            dayVBox.setAlignment(Pos.CENTER);
	
	            hbox.getChildren().add(dayVBox);
	            hbox.setSpacing(55);
	        }
	        
	        sp.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
	        sp.setContent(hbox);
		}
	        
	        
	private void setUpHourlyForecastContainer(WeatherManager weatherManager, ScrollPane sp, String cityName ) throws APIException {
		
	    			HBox hbox = new HBox();
	            
	            	for (HourlyWeatherConditions hourlyWeatherConditions : weatherManager.fetchHourlyWeatherForecast(cityName)) {
	                
		            	
	            		VBox dayVBox = new VBox();
		
		                Label dateLabel = new Label(hourlyWeatherConditions.getDateToHourlyForecast());
		                dateLabel.setStyle("-fx-font-size: 15px;");
		
		                Label temperatureLabel = new Label(hourlyWeatherConditions.getTemperature());
		                
		                Label pressureLabel = new Label(hourlyWeatherConditions.getPressure());
	
		                Image icon = new Image(hourlyWeatherConditions.getIconUrl());
		                ImageView imageView = new ImageView(icon);
		                imageView.autosize();
		                
		                dayVBox.getChildren().addAll(
		                        dateLabel,
		                        imageView,
		                        temperatureLabel,
		                        pressureLabel
		                );
		               
		                dayVBox.setAlignment(Pos.CENTER);
		
		                hbox.getChildren().add(dayVBox);
		                hbox.setSpacing(45);
	                   
	            }
	            
	            sp.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
	            sp.setContent(hbox);
	            
		}
	        
}
