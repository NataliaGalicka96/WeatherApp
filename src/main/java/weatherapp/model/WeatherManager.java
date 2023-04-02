package weatherapp.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import weatherapp.Config;

public class WeatherManager {
	
	/*
	private String cityName = "Truskaw";
	
	String YOUR_API_KEY = Config.API_KEY;
	
	String UNIT_GROUP = Config.UNIT_GROUP;
	
	String CONTENT_TYPE = Config.CONTENT_TYPE;
	
	public String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + cityName + "?unitGroup=" + UNIT_GROUP + "&key=" + YOUR_API_KEY + "&contentType=" + CONTENT_TYPE + "&lang=pl";
	
	public String  getUrlString() {
		return url;
	}
	*/
	
	public String url;

	
	public void getWeatherData(TextField chooseLocation, Label currentCity, Label currentDate,
			Label currentDegree11, Label currentHumidity, ImageView currentPicture1, 
			Label currentPressure2, Label currentTime, Label currentWindSpeed, Label description,
			Label sensedTemperature, HBox weatherNextDay) {
		
		APIConnector apiConn = new APIConnector();
		
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
	      
	      ZoneId zoneId=ZoneId.of(json.getString("timezone"));

			
	      
	      currentCity.setText(json.get("resolvedAddress").toString());
	      currentDegree11.setText(values.get("temp").toString());
	      currentHumidity.setText(values.get("humidity").toString());
	      currentPressure2.setText(values.get("pressure").toString());
	      currentWindSpeed.setText(values.get("windspeed").toString());
	      sensedTemperature.setText("Temperatura odczuwalna: " + values.get("feelslike").toString());
	      description.setText(values.get("conditions").toString());
	      
	      
	      
	      JSONArray jsonArray = json.getJSONArray("days");
	      System.out.println(jsonArray);
			
			System.out.println("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");

			for (int i = 0; i < 5; i++) {
				JSONObject dayValue = jsonArray.getJSONObject(i);
	            
	            ZonedDateTime datetime=ZonedDateTime.ofInstant(Instant.ofEpochSecond(dayValue.getLong("datetimeEpoch")), zoneId);
	            
	            double maxtemp=dayValue.getDouble("tempmax");
	         
	            double mintemp=dayValue.getDouble("tempmin");
	            
	            
	            
	            String maxT = Double.toString(maxtemp);
	            
	            String minT = Double.toString(mintemp);

	            System.out.println("%s\t%.1f\t%.1f\t%.1f\t%s%n" + " " + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + maxtemp + " " + mintemp );
		
	            System.out.println("%s\t%.1f\t%.1f\t%.1f\t%s%n" + " " + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + maxT + " " + minT );
	    		
	            
	            HBox nextTemp =  new HBox(15);
	            
	          
	            Label maxTemp = new Label();
	            maxTemp.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
	            maxTemp.setText(maxT);
	            
	            Label minTemp = new Label();
	            minTemp.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
	            minTemp.setText(minT);
	            
	            
	           
		    	nextTemp.getChildren().add(maxTemp);
		    	nextTemp.getChildren().add(minTemp);
		    		
		    	  VBox dayNext = new VBox(15);
		    	 
		    	  String dateString = datetime.format(DateTimeFormatter.ISO_LOCAL_DATE);
		    	  Label date2 = new Label(dateString);
		    	  
		    	  date2.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		    	  
		    	  
		    	  dayNext.getChildren().add(date2);
		    	//dayNext.getChildren().add(new ImageView("zdjęcie"));
		    	  dayNext.getChildren().add(nextTemp);
		    	  
		    	  
		    	  weatherNextDay.getChildren().add(dayNext);
		    	  
		    	//dayNext.setAlignment(CENTER);
		    	  dayNext.setPrefHeight(243.0);
		    	  dayNext.setPrefWidth(190.0);
		    	  
		    	  weatherNextDay.setPadding(new Insets(20.0));
			
			}
			
			
			
			//LocalDate customerBirthday = klient.loadBirthdayFromDatabase();
			  LocalDate dzisiaj = LocalDate.now();
			  System.out.println(dzisiaj);
	
	
	}





	public WeatherManager(String url) {
		super();
		this.url = url;
	}



}
