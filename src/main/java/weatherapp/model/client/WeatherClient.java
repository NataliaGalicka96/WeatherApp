package weatherapp.model.client;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import net.aksingh.owmjapis.api.APIException;
import weatherapp.model.DailyWeatherConditions;
import weatherapp.model.HourlyWeatherConditions;

public interface WeatherClient {
	
	public void getWeather(TextField chooseLocation, Label city,
			Label degree, Label humidity, ImageView picture, 
			Label pressure, Label windSpeed, Label description) throws APIException;
	
	boolean checkCity(String cityName);

	List<HourlyWeatherConditions> getHourlyForecast(String cityName) throws APIException;
	
	List<DailyWeatherConditions> getDailyForecast(String cityName) throws APIException;
	
}
