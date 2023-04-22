package weatherapp.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import weatherapp.Config;

public class APIConnector {
	
	

	public int getResponseCode(String url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("GET");

		//check if connect is made
		int responseCode = connection.getResponseCode();
		
		return responseCode;
	}
	
	public HttpURLConnection connect(String url) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		
		connection.setRequestMethod("GET");
		
		
		return connection;
	}
	
	
	public JSONObject connectToAPI(String url) {
		
		try {
			
			HttpURLConnection connection = connect(url);
			int responseCode = getResponseCode(url);
			
			//System.out.println("GET Response Code :: " + responseCode);
			
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				String responseString = response.toString();
				
				JSONObject json = new JSONObject(responseString);
				
				return json;

			       
			} else {
				System.out.println("GET request did not work.");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	/*
	public Map<String, Integer> getCitiesMapFromJSON(String source) throws FileNotFoundException {

        try {
            Map<String, Integer> citiesMap =
                    new TreeMap<>();

            JsonReader reader = new JsonReader(new InputStreamReader(getClass().getResourceAsStream(source)));
            Gson gson = new GsonBuilder().create();
            City[] cities = gson.fromJson(reader, City[].class);

            for (City city : cities) {
                citiesMap.put(city.getCityName() + "," + city.getCountryCode(), city.getCityId());
            }

            return citiesMap;
            
        } catch (NullPointerException e) {
            throw new FileNotFoundException();
        }
    }*/
	
	public City fromJsonString (String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, City.class);
	}
	
}
