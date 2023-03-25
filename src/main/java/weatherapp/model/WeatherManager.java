package weatherapp.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import weatherapp.Config;

public class WeatherManager {
	
	String cityName = "Izabelin";
	
	String YOUR_API_KEY = Config.API_KEY;
	
	String UNIT_GROUP = Config.UNIT_GROUP;
	
	String CONTENT_TYPE = Config.CONTENT_TYPE;
	
	public String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";
	
	public String  getUrlString() {
		return url;
	}
	
	
	public void getWeatherData(TextField chooseLocation, Label currentCity, Label currentDate,
			Label currentDegree11, Label currentHumidity, ImageView currentPicture1, 
			Label currentPressure2, Label currentTime, Label currentWindSpeed, Label description,
			Label sensedTemperature) {
		
		APIConnector apiConn = new APIConnector(cityName);
		
		JSONObject json = apiConn.connectToAPI(url);
		
	      System.out.println(json);
	     // System.out.println(jsonArr);
	      System.out.println(json.get("resolvedAddress"));
	      System.out.println(json.get("address"));
	      //JSONArray values = json.getJSONArray("currentConditions");
	      JSONObject values = json.getJSONObject("currentConditions");
	      System.out.println(values);
	      
	     
				
	      System.out.println(values.get("icon"));
	      System.out.println(values.get("humidity"));
	      System.out.println(values.get("datetime"));
	      System.out.println(values.get("temp"));
	      System.out.println(values.get("feelslike"));
	      System.out.println(values.get("pressure"));
	      System.out.println(values.get("windspeed"));
	      System.out.println(values.get("conditions"));
	     // System.out.println(values.get("description"));
	      
	      currentCity.setText(json.get("resolvedAddress").toString());
	      currentDegree11.setText(values.get("temp").toString());
	      currentHumidity.setText(values.get("humidity").toString());
	      currentPressure2.setText(values.get("pressure").toString());
	      currentWindSpeed.setText(values.get("windspeed").toString());
	      sensedTemperature.setText("Temperatura odczuwalna: " + values.get("feelslike").toString());
	      description.setText(values.get("conditions").toString());
	      
	      ZoneId zoneId=ZoneId.of(json.getString("timezone"));
	      JSONArray jsonArray = json.getJSONArray("days");
	      System.out.println(jsonArray);
			
			System.out.println("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject dayValue = jsonArray.getJSONObject(i);
	            
	            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);
	            
	            double maxtemp=dayValue.getDouble("tempmax");
	            double mintemp=dayValue.getDouble("tempmin");
	            double pop=dayValue.getDouble("precip");
	            String source=dayValue.getString("source");
	            System.out.println("%s\t%.1f\t%.1f\t%.1f\t%s%n" + " " + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + maxtemp + " " + mintemp + " " + pop + " " + source );
		
	}
	
	
	}
}
