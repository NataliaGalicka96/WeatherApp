package weatherapp.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import weatherapp.model.CityHandler;
import weatherapp.model.DailyWeatherConditions;
import weatherapp.model.HourlyWeatherConditions;
import weatherapp.model.WeatherService;
import weatherapp.model.WeatherServiceFactory;
import weatherapp.model.client.WeatherClient;

public class MainWindowController extends BaseController implements Initializable{
	
	
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
	    private Label currentLabel;
	    
	    @FXML
	    private Label desiredLabel;

	    public MainWindowController(String fxmlName) { 
	        super(fxmlName);
	    }
	    
	    private WeatherService weatherService;
	    		
		
		public void initialize(URL location, ResourceBundle resources) {
			
			weatherService = WeatherServiceFactory.createWeatherService();
			
			 CityHandler cityProvider = new CityHandler();
			 cityProvider.getCityListFromJsonFile(chooseCurrentLocation);
			 cityProvider.getCityListFromJsonFile(chooseDesiredLocation);

			dailyCurrentLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
			hourlyCurrentLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
			currentLabel.setText("Wybierz miasto, aby zobaczyć prognozę pogody");
					
			dailyDesiredLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
			hourlyDesiredLocationWeather.setStyle("-fx-background:  #1e1e36; -fx-background-radius: 20; -fx-border-color: #1e1e36; -fx-border-radius: 20; ");
			desiredLabel.setText("Wybierz miasto, aby zobaczyć prognozę pogody");
					
	}
		
	    @FXML
	    void getDesiredLocation(ActionEvent event) throws IOException {
	    	
	    	WeatherClient weatherClient = weatherService.getWeatherClient();
	    	
	    	String city = chooseDesiredLocation.getText();
	    	desiredLabel.setText("");
	    			
			try {
				
				weatherClient.getWeather(chooseDesiredLocation, desiredCityName,
						desiredDegree,desiredHumidity, desiredIcon, desiredPressure, desiredWindSpeed, desiredDescription);

					if (!weatherClient.getDailyForecast(city).isEmpty()) {
					        setUpExtendedForecastView(weatherClient, dailyDesiredLocationWeather, city);
					    } else {
					   System.out.println("Brak danych dla tego miasta");
					    }
					
		
					if (!weatherClient.getHourlyForecast(city).isEmpty()) {
						setUpHourlyForecastContainer(weatherClient, hourlyDesiredLocationWeather, city);
					    } else {
					   System.out.println("Brak danych dla tego miasta");
					    }
						
			} catch (APIException e) {

				e.printStackTrace();
			}

	    }

	    @FXML
	    void getCurrentLocation(ActionEvent event) {
	    	
	    	WeatherClient weatherClient = weatherService.getWeatherClient();
	    	
	    	String city = chooseCurrentLocation.getText();
	    	
	    	currentLabel.setText("");
	    	
			try {
				
				weatherClient.getWeather(chooseCurrentLocation, currentCityName,
						currentDegree,currentHumidity, currentIcon, currentPressure, currentWindSpeed, currentDescription);


					if (!weatherClient.getDailyForecast(city).isEmpty()) {
					        setUpExtendedForecastView(weatherClient, dailyCurrentLocationWeather, city);
					    } else {
					    	 System.out.println("Brak danych dla tego miasta");
					    }
					
		
					if (!weatherClient.getHourlyForecast(city).isEmpty()) {
						setUpHourlyForecastContainer(weatherClient, hourlyCurrentLocationWeather, city);
					    } else {
					    	 System.out.println("Brak danych dla tego miasta");
					    }
						
			} catch (APIException e1) {

				e1.printStackTrace();
			}

	    }
  

	
	private void setUpExtendedForecastView(WeatherClient weatherClient, ScrollPane sp, String cityName) throws APIException {
			
			HBox hbox = new HBox();
			
	        for (DailyWeatherConditions dailyWeatherConditions : weatherClient.getDailyForecast(cityName)) {
	           
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
	        
	        
	private void setUpHourlyForecastContainer(WeatherClient weatherClient, ScrollPane sp, String cityName ) throws APIException {
		
	    			HBox hbox = new HBox();
	            
	            	for (HourlyWeatherConditions hourlyWeatherConditions : weatherClient.getHourlyForecast(cityName)) {
	                
		            	
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
