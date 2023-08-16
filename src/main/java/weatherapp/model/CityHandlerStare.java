package weatherapp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import javafx.scene.control.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;


public class CityHandlerStare {
	
	public static Map<String, Integer> citiesMap;
	public static City[] cities;

	public Map<String, Integer> getCityListFromJsonFile(TextField chooseLocation) {
    	
    	Map<String, Integer> citiesMap = new TreeMap<>();
  
		InputStream inputStream = null;
		            
        try {
            inputStream = new FileInputStream("D:\\WeatherApp\\src\\main\\resources\\weatherapp\\city.list.min.json");
        }  catch (FileNotFoundException e) {
        	e.printStackTrace();
        	System.out.println("Problem z wczytaniem pliku");
        }
		            
        JsonReader reader = null;
        
		try {
			reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Gson gson = new GsonBuilder().create();

		City[] cities = gson.fromJson(reader, City[].class);
	
		for (City city : cities) {
			 citiesMap.put(city.getName() + ", " + city.getCountry(), city.getId());
		}

		AutoComplete.autoComplete(chooseLocation, citiesMap);
					
					
		return citiesMap;

    }
    
}