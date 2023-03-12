package weatherapp.model;

public class Location {

    private String cityName;

    public Location(String cityName){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }
}
