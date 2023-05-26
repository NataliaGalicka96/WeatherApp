package weatherapp.model;

public class City {

    private String name;
    private String country;
    private Integer id;
    
   
    public City(String name, String country, Integer id) {
        this.name = name;
        this.country = country;
        this.id = id;

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
   

}

