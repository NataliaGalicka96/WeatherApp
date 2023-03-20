package weatherapp.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class APIConnector {
	
	private final String urlString;
	
	// urlString = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Izabelin?unitGroup=metric&key=9R52M7Z6XFEXLGT8NHVU9QYPF&contentType=json"

	String myAPIKey = "";
	String unitGroup= "metric";
	
	public APIConnector(String urlString) throws MalformedURLException {
		this.urlString = urlString;
	}
	
	/*
	
	public JSONArray getJSONArray(String urlString) {
		try {
			
			//try connecting to rest api
			HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
			connection.setRequestMethod("GET");

			//check if connect is made
			int responseCode = connection.getResponseCode();
			
		
			//System.out.println("GET Response Code :: " + responseCode);
			
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				//String string = response.toString();
				
				//print result
				//System.out.println(string);
				//System.out.println(string);
				
				//return string;
			       
			} else {
				System.out.println("GET request did not work.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
    */
    
 
	
	
}
