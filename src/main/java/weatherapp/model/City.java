package weatherapp.model;

import org.json.simple.JSONObject;

public class City {

    private String name;
    private String country;
    private Integer id;

 
    JSONObject coord;
    
   
    public City(String name, String country, Integer id, JSONObject coord) {
        this.name = name;
        this.country = country;
        this.id = id;
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
    

    public Integer getId() {
        return id;
    }
    
    public JSONObject getCoord() {
    	return coord;
    }
    
    
    
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}

