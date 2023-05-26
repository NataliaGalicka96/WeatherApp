package weatherapp.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.Weather;
import net.aksingh.owmjapis.model.param.WeatherData;

public class WeatherManager{
	
	OWMWeather owm = new OWMWeather();
	
	public void getWeatherData(TextField chooseLocation, Label city,
			Label degree, Label humidity, ImageView picture, 
			Label pressure, Label windSpeed, Label description, CurrentWeather cwd){
		

				city.setText(cwd.getCityName().toString());
				city.getStyleClass().add("city");
			    degree.setText((int) Math.round(cwd.getMainData().getTemp()) +  "\u00b0");
			    pressure.setText("Ciśnienie: " + (int) Math.round(cwd.getMainData().getPressure()) + " hPa");
			    humidity.setText("Wilgotność: " + (int) Math.round(cwd.getMainData().getHumidity()) + " %");
			    windSpeed.setText("Wiatr: " + (int) Math.round(cwd.getWindData().getSpeed()) + " m/s");
			    
			    for (Weather data: cwd.getWeatherList()) {
			    	
			    		String dscrpt = data.getMoreInfo();
			    	
			          	description.setText(dscrpt.substring(0, 1).toUpperCase() + dscrpt.substring(1));

			  	        Image weatherImage = new Image(cwd.getWeatherList().get(0).getIconLink());	

			  	        picture.setFitHeight(150);
			  	        picture.setFitWidth(150);
			  	        picture.setImage(weatherImage);
			    }
			  	                
	}
	

	public List<DailyWeatherConditions> fetchDailyWeatherForecast(String cityName) throws APIException {
	    HourlyWeatherForecast hourlyWeatherForecast = owm.getHourlyWeather(cityName);
	    
	    List<DailyWeatherConditions> dailyWeatherForecast = new ArrayList<>();
	
	    if (hourlyWeatherForecast.hasRespCode() && hourlyWeatherForecast.getRespCode().equals("200")) {
	        double dayTemperature = 0;
	        double nightTemperature;
	        WeatherData dayWeather = null;
	
	        for (WeatherData weatherData : hourlyWeatherForecast.getDataList()) {
	
	            Date date = weatherData.getDateTime();
	           
	            if (getDayOfWeek(new Date()) != getDayOfWeek(date)) {
	                int hour = getHour(date);
	
	                if (isDayTemperature(hour)) {
	                    dayTemperature = weatherData.getMainData().getTemp();
	                    dayWeather = weatherData;
	                }
	
	                if (isNightTemperature(hour) && dayTemperature != 0) {
	                    nightTemperature = weatherData.getMainData().getTemp();
	                    
	                    DailyWeatherConditions dailyWeatherConditions = new DailyWeatherConditions(dayWeather, (int) Math.round(dayTemperature), (int) Math.round(nightTemperature));
	                    dailyWeatherForecast.add(dailyWeatherConditions);
	                    dayTemperature = 0;
	                }
	            
	            }
	            
	        }
	    }
	
	    return dailyWeatherForecast;
	}
	
	public List<HourlyWeatherConditions> fetchHourlyWeatherForecast(String cityName) throws APIException {
	    HourlyWeatherForecast hourlyWeatherForecast = owm.getHourlyWeather(cityName);
	    List<HourlyWeatherConditions> hourlyWeatherForecastList = new ArrayList<>();
	
	    if (hourlyWeatherForecast.hasRespCode() && hourlyWeatherForecast.getRespCode().equals("200")) {
	        double temperature = 0;
	        WeatherData dayWeather = null;
	
	        for (WeatherData weatherData : hourlyWeatherForecast.getDataList()) {
	
	      
	        	 dayWeather = weatherData;
	        
	        	 temperature = weatherData.getMainData().getTemp();
	                    
	              HourlyWeatherConditions hourlyWeatherConditions = new HourlyWeatherConditions(dayWeather, (int) Math.round(temperature));
	                    hourlyWeatherForecastList.add(hourlyWeatherConditions);

	                
	                if (hourlyWeatherForecastList.size() == 10) {
	                    break;
	                }
	            }
	        }
	    
	    return hourlyWeatherForecastList;
	}
	
    private DayOfWeek getDayOfWeek(Date date) {
        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDate.getDayOfWeek();
    }

    private int getHour(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getHour();
    }
    
	private boolean isNightTemperature(int hour) {
        return hour > 21 || hour == 0;
    }

    private boolean isDayTemperature(int hour) {
        return hour > 12 && hour <= 15;
    }
	
}

