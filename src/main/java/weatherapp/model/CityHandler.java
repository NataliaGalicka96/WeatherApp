package weatherapp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import weatherapp.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

public class CityHandler {
	
	
	public Map<String, Integer> getCityListFromJsonFile(String fileName) throws IOException {
       
		Map<String, Integer> citiesMap = new TreeMap<>();
		
		InputStream inputStream = null;
		
		try {
           inputStream = new FileInputStream("D:\\WeatherApp\\src\\main\\resources\\weatherapp\\"+Config.CITY_LIST_WITH_DATA);
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
				
		return citiesMap;
	}
}

