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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

        System.out.println("Szukaj lokalizacji");

        HttpURLConnection connection = (HttpURLConnection) new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Izabelin?unitGroup=metric&key=9R52M7Z6XFEXLGT8NHVU9QYPF&contentType=json").openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//JSONParser parse = new JSONParser();

           // (JSONArray) parse.parse(String.valueOf(response));
			
			String string = response.toString();
			
			//print result
			//System.out.println(string);
			//System.out.println(string);
			
			JSONObject json = new JSONObject(string);
			//JSONArray jsonArr = new JSONArray(string);
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
		      
		
        } else 
			System.out.println("GET request did not work.");
		}
     
    

    public CurrentWeatherController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }
}
