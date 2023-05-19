package weatherapp.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.Weather;
import net.aksingh.owmjapis.model.param.WeatherData;

public class WeatherManager {
	
	OWMWeather owm = new OWMWeather();


	public void getWeatherData(TextField chooseLocation, Label city, Label date,
			Label degree, Label humidity, ImageView picture, 
			Label pressure, Label windSpeed, Label description){
		
		//Wyczyścić dane znajdujące się już w widoku
		
		//Wybrać miasto z listy rozwijanej, pobrać wartość wybraną i podstawić zamiast "Izabelin"

	       CurrentWeather cwd;
	       
	        try {
	        	
	        	cwd = owm.getCurrentWeather("Izabelin");
				
	        	System.out.println(cwd);
				
			    System.out.println(cwd.getDateTime());
			    
			    

				city.setText(cwd.getCityName().toString());
			    degree.setText(cwd.getMainData().getTemp().toString());
			    pressure.setText("Ciśnienie: " + cwd.getMainData().getPressure().toString() + "hPa");
			    humidity.setText("Wilgotność: " + cwd.getMainData().getHumidity().toString() + " %");
			    windSpeed.setText("Wiatr: " + cwd.getWindData().getSpeed().toString() + " m/s");
			    
			    for (Weather data: cwd.getWeatherList()) {
			    	
			          	description.setText(data.getMoreInfo());

			  	        Image weatherImage = new Image(cwd.getWeatherList().get(0).getIconLink());	  	    
			  	        picture.setImage(weatherImage);

			    }

			  
			          
			} catch (APIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
    private DayOfWeek getDayOfWeek(Date date) {
        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDate.getDayOfWeek();
    }

    private int getHour(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getHour();
    }
    
    private int getMinute(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getMinute();
    }
    
	private boolean isNightTemperature(int hour) {
        return hour > 21 || hour == 0;
    }

    private boolean isDayTemperature(int hour) {
        return hour > 12 && hour <= 15;
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
	
	                if (dailyWeatherForecast.size() == 5) {
	                    break;
	                }
	            }
	        }
	    }
	
	    return dailyWeatherForecast;
	}

	public void fetchHourlyWeatherForecast(String cityName, HBox hbox) throws APIException {
	    HourlyWeatherForecast hourlyWeatherForecast = owm.getHourlyWeather(cityName);
	   // List<DailyWeatherConditions> dailyWeatherForecast = new ArrayList<>();
	
	    if (hourlyWeatherForecast.hasRespCode() && hourlyWeatherForecast.getRespCode().equals("200")) {
	
	
	        for (WeatherData weatherData : hourlyWeatherForecast.getDataList()) {
	           
	        	Date date = weatherData.getDateTime();
	            int date1 = getHour(date);
	            int date2 = getMinute(date);
	            
	            String dateText = date1 + ":" + date2 + 0;
	        
	
	            if (getDayOfWeek(new Date()) == getDayOfWeek(date)) {
	
	
	            		VBox dayVBox = new VBox();
	            		
	                    Label dateLabel = new Label(dateText);
	                    dateLabel.getStyleClass().add("date-label");
	
	                    Label temperatureLabel = new Label(weatherData.getMainData().getTemp().toString());
	                    temperatureLabel.getStyleClass().add("bolder");
	                    
	                    Label pressureLabel = new Label(weatherData.getMainData().getPressure().toString());
	                    temperatureLabel.getStyleClass().add("smaller");
	
	                    dayVBox.getChildren().addAll(
	                            dateLabel,
	                            new ImageView(new Image(weatherData.getWeatherList().get(0).getIconLink())),
	                            temperatureLabel,
	                            pressureLabel
	                    );
	                    
	                    dayVBox.setAlignment(Pos.CENTER);
	
	             
	                    hbox.getChildren().add(dayVBox);   
	            }
	             
	            
	        }
	    }
	
	}

}

		
	   		
	   		
	   		
	   		
	   		
		
	      		 
	        		
	        	 
	       

	         
	//}

	        
/*
		if(json != null)
		{
	      System.out.println(json.get("resolvedAddress"));
	      System.out.println(json.get("address"));
	      
	      JSONObject values = json.getJSONObject("currentConditions");
	      
	      ZoneId zoneId=ZoneId.of(json.getString("timezone"));

	      FileInputStream weatherIcon = null;
		
	      try {
			weatherIcon = new FileInputStream("D:\\WeatherApp\\src\\main\\resources\\weatherapp\\images\\sunny.png");
	      } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Błąd podczas wczytywania obrazka");
			e.printStackTrace();
	      }
	      
	        Image weatherImage = new Image(weatherIcon);
	        picture.setImage(weatherImage);
	        
	        
	        ImageView imageView = new ImageView(weatherImage);
	        imageView.setFitHeight(80);
	        imageView.setFitWidth(80);
			
	      
	      currentCity.setText(json.get("resolvedAddress").toString());
	      currentDegree11.setText(values.get("temp").toString());
	      currentHumidity.setText("Wilgotność: "+ values.get("humidity").toString() + " %");
	      currentPressure2.setText("Ciśnienie: " + values.get("pressure").toString() + " mbar");
	      currentWindSpeed.setText("Wiatr: " + values.get("windspeed").toString() + " km/h");
	      sensedTemperature.setText("Temperatura odczuwalna: " + values.get("feelslike").toString());
	      description.setText(values.get("conditions").toString());
	      currentPicture1.setImage(weatherImage);
	      
	      
	      
	       JSONArray jsonArray = json.getJSONArray("days");
	       
			
	       nextDayWeatherContainer.getChildren().clear();

			
			for (int i = 0; i < 4; i++) {
				

				JSONObject dayValue = jsonArray.getJSONObject(i);
	            
	            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);
	            
	            double maxtemp=dayValue.getDouble("tempmax");
	         
	            double mintemp=dayValue.getDouble("tempmin");
	            
	            
	            
	            String maxT = Double.toString(maxtemp);
	            
	            String minT = Double.toString(mintemp);

	            System.out.println("%s\t%.1f\t%.1f\t%.1f\t%s%n" + " " + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + maxtemp + " " + mintemp );
		
	            System.out.println("%s\t%.1f\t%.1f\t%.1f\t%s%n" + " " + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + maxT + " " + minT );
	    		
	    		HBox nextTemp =  new HBox(15);
	    		nextTemp.setAlignment(Pos.CENTER);
	            Label maxTemp = new Label();
	            VBox dayNext = new VBox(10);
	            
	            maxTemp.setFont(Font.font(17));
	            maxTemp.setTextFill(Color.WHITE);
	            maxTemp.setText(maxT);
	            
	            Label minTemp = new Label();
	            minTemp.setFont(Font.font(17));
	            minTemp.setTextFill(Color.GREY);
	            minTemp.setText(minT);
	            
	           
		    	nextTemp.getChildren().add(maxTemp);
		    	nextTemp.getChildren().add(minTemp);
		    		
		    	
		    	String dateString = datetime.format(DateTimeFormatter.ISO_LOCAL_DATE);
		        Label date2 = new Label(dateString);
		    	  
		        date2.setFont(Font.font(17));
		        date2.setTextFill(Color.WHITE);
		       
		        FileInputStream iconNextDay = null;
				try {
					iconNextDay = new FileInputStream("D:\\WeatherApp\\src\\main\\resources\\weatherapp\\images\\sunny.png");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		        Image imageNextDay = new Image(iconNextDay);
		        ImageView imageView1 = new ImageView(imageNextDay);
		        imageView1.setFitHeight(70);
		        imageView1.setFitWidth(70);
		    	
		    	  
		    	dayNext.getChildren().add(date2);
		    	dayNext.getChildren().add(imageView1);
		    	dayNext.getChildren().add(nextTemp);
		    	
		    	dayNext.setAlignment(Pos.CENTER);
		    	  
		    	  
		    	nextDayWeatherContainer.getChildren().add(dayNext);
		    	  
		    	 dayNext.setPrefHeight(243.0);
		    	 dayNext.setPrefWidth(190.0);
		    	  
			
			}
				
		
	}else {
		System.out.println("Brak danych");
	}
}
*/


