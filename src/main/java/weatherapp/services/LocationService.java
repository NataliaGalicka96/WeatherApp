package weatherapp.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import weatherapp.model.Location;

public class LocationService {
	
	
	/*

    Location location;

    //https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Izabelin?unitGroup=metric&key=YOUR_API_KEY&contentType=json
    private final String cityAPIEndPoint = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    private String ApiKey = "";
    private String unitGroup = "metric";
    private String city = location.getCityName();




    protected void setCityFromInput() {
        if(city.equals("")){
            //Alert wyświetlic
            System.out.println("Uzupełnij miasto");
            return;
        }
    }
    
  //Build a String from the read Json file
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    //Reads and returns the JsonObject
    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    */

}
