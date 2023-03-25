package weatherapp.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import weatherapp.Config;

public class APIConnector {
	

	String location;
	
	
	public APIConnector(String location) {
		this.location = location;
	}
	

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
	
}
