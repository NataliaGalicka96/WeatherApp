package weatherapp.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


import org.json.JSONArray;
import org.json.JSONObject;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WeatherManager {
	
	
	public String url;
	
	public WeatherManager(String url) {
		super();
		this.url = url;
	}
	

	public void getWeatherData(TextField chooseLocation, Label currentCity, Label currentDate,
			Label currentDegree11, Label currentHumidity, ImageView currentPicture1, 
			Label currentPressure2, Label currentWindSpeed, Label description,
			Label sensedTemperature, HBox weatherNextDay, HBox nextDayWeatherContainer){
		
	
		APIConnector apiConn = new APIConnector();
		
		JSONObject json = apiConn.connectToAPI(url);
		
	      //System.out.println(json);
	      //System.out.println(jsonArr);
	      System.out.println(json.get("resolvedAddress"));
	      System.out.println(json.get("address"));
	      
	      JSONObject values = json.getJSONObject("currentConditions");
	      //System.out.println(values);
	 
	      
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
	       
	       //System.out.println(jsonArray);
		   //System.out.println("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
			
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
				
		
	}
	

}
