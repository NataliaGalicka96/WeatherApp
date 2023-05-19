package weatherapp.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import weatherapp.model.City;
import weatherapp.model.DailyWeatherConditions;
import weatherapp.model.WeatherManager;



public class CurrentWeatherController extends BaseController implements Initializable{

	  @FXML
	    private VBox body;

	    @FXML
	    private HBox hourlyCurrentLocationWeather;
	    
	    @FXML
	    private HBox dailyCurrentLocationWeather;
	    
	    @FXML
	    private TextField chooseCurrentLocation;

	    @FXML
	    private TextField chooseDesiredLocation;

	    @FXML
	    private Label currentCityName;

	    @FXML
	    private Label currentDate;

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
	    private Label currentSensedTemperature;

	    @FXML
	    private Label currentWindSpeed;

	    @FXML
	    private Label desiredCityName;

	    @FXML
	    private Label desiredDate;

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
	    private Label desiredSensedTemperature;

	    @FXML
	    private Label desiredWindSpeed;
	    
	    @FXML
	    private ImageView icon;

	    @FXML
	    private Label temp;
	    
	    @FXML
	    private Label clock;

	    @FXML
	    void getCurrentLocation(ActionEvent event) {

	    }

	    @FXML
	    void getDesiredLocation(ActionEvent event) {

	    }
	    
	    private Map<String, Integer> citiesMap;

	    private City[] cities;
	    
	    public CurrentWeatherController(String fxmlName) { 
	        super(/*weatherManager, viewFactory,*/ fxmlName);
	    }

/*
		@FXML
	    void getDesiredLocation(ActionEvent event) throws IOException {
	    	String cityName = chooseLocation1.getText();
	    	System.out.print(cityName);
	    	
	    }
	    
	        
	    @FXML
	    void getCurrentLocation(ActionEvent event) throws IOException {


	    	hboxNextDayWeather.getChildren().clear();
	    	CityHandler cityProvider2 = new CityHandler();
	    	citiesMap = cityProvider2.getCityListFromJsonFile(chooseLocation);
	    	cities = cityProvider2.getCityaRRAY();
	  

	    	String cityName = chooseLocation.getText();
	    	System.out.println(cityName);


	    	String YOUR_API_KEY = Config.API_KEY;

	    	String UNIT_GROUP = Config.UNIT_GROUP;

	    	String CONTENT_TYPE = Config.CONTENT_TYPE;


			String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";


	    	WeatherManager weatherManager = new WeatherManager(url);


	    	weatherManager.getWeatherData(chooseLocation, currentCity, currentDate,
	    			currentDegree11,currentHumidity, currentPicture1, currentPressure2, currentWindSpeed, description,
	sensedTemperature, weatherNextDay, hboxNextDayWeather);

	    }
	    
*/

	public void initialize(URL location, ResourceBundle resources) {

		/*
		 CityHandler cityProvider2 = new CityHandler();
		 cityProvider2.getCityListFromJsonFile(chooseLocation);
		cityProvider2.getCityListFromJsonFile(chooseLocation1);
		 */
		WeatherManager weatherManager = new WeatherManager();
    	
				weatherManager.getWeatherData(chooseCurrentLocation, currentCityName, currentDate,
						currentDegree,currentHumidity, currentIcon, currentPressure, currentWindSpeed, currentDescription);

				
				 try {
					if (!weatherManager.fetchDailyWeatherForecast("Izabelin").isEmpty()) {
					        setUpExtendedForecastView(weatherManager, dailyCurrentLocationWeather);
					    } else {
					   System.out.println("Błąd");
					    }
					
				} catch (APIException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				 try {
					weatherManager.fetchHourlyWeatherForecast("Izabelin", hourlyCurrentLocationWeather);
				} catch (APIException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
  
	}

	private void setUpExtendedForecastView(WeatherManager weatherManager, HBox hbox ) throws APIException {
		
        for (DailyWeatherConditions dailyWeatherConditions : weatherManager.fetchDailyWeatherForecast("Izabelin")) {
            
        	VBox dayVBox = new VBox();

            Label dateLabel = new Label(dailyWeatherConditions.getDate());
            dateLabel.getStyleClass().add("date-label");
            Label descriptionLabel = new Label(dailyWeatherConditions.getDescription());
            descriptionLabel.getStyleClass().add("bolder");

            Label temperatureLabel = new Label(dailyWeatherConditions.getTemperature());
            temperatureLabel.getStyleClass().add("bolder");
            Label pressureLabel = new Label(dailyWeatherConditions.getPressure());
            temperatureLabel.getStyleClass().add("smaller");

            dayVBox.getChildren().addAll(
                    dateLabel,
                    new ImageView(new Image(dailyWeatherConditions.getIconUrl())),
                    descriptionLabel,
                    temperatureLabel,
                    pressureLabel
            );
            dayVBox.setAlignment(Pos.CENTER);

            hbox.getChildren().add(dayVBox);
            hbox.setSpacing(35);
        }
	}
        
      
	

}
