package weatherapp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CityHandler {
	
	
	public Map<String, Integer> getCityListFromJsonFile(String fileName) throws IOException {
        Map<String, Integer> citiesMap = new TreeMap<>();
        

        try (InputStream inputStream = getClass().getResourceAsStream("/weatherapp/" + fileName)) {
            if (inputStream == null) {
                System.out.println("Problem z wczytaniem pliku");
                return citiesMap;
            }

            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            Gson gson = new GsonBuilder().create();

            City[] cities = gson.fromJson(reader, City[].class);

            for (City city : cities) {
                citiesMap.put(city.getName() + ", " + city.getCountry(), city.getId());
            }

           // AutoComplete.autoComplete(chooseLocation, citiesMap);

        } catch (JsonSyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return citiesMap;
    }

    /*public Map<String, Integer> getCityListFromJsonFile(TextField chooseLocation) throws IOException {
        Map<String, Integer> citiesMap = new TreeMap<>();

        try (InputStream inputStream = getClass().getResourceAsStream("/weatherapp/city.list.min.json")) {
            if (inputStream == null) {
                System.out.println("Problem z wczytaniem pliku");
                return citiesMap;
            }

            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            Gson gson = new GsonBuilder().create();

            City[] cities = gson.fromJson(reader, City[].class);

            for (City city : cities) {
                citiesMap.put(city.getName() + ", " + city.getCountry(), city.getId());
            }

            AutoComplete.autoComplete(chooseLocation, citiesMap);

        } catch (JsonSyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return citiesMap;
    }
    */
}
