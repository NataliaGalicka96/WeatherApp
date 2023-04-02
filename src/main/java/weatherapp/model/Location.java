package weatherapp.model;

import io.ipgeolocation.api.IPGeolocationAPI;

public class Location {

    private String cityName;


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    
    public void getCurrentLocation() {
    	// Create IPGeolocationAPI object, passing your valid API key
    	IPGeolocationAPI api = new IPGeolocationAPI("0880a19beaff4c19ad09475bcb583d02");
    	/*
    	// Get geolocation for IP address (185.238.205.205) and fields (geo, time_zone and currency)
    	GeolocationParams geoParams = new GeolocationParams();
    	geoParams.setIPAddress("185.238.205.205");
    	geoParams.setFields("geo,time_zone,currency");

    	Geolocation geolocation = api.getGeolocation(geoParams);

    	// Check if geolocation lookup was successful
    	if(geolocation.getStatus() == 200) {
    	    System.out.println(geolocation.getCountryName());
    	    System.out.println(geolocation.getCurrency().getName());
    	    System.out.println(geolocation.getTimezone().getCurrentTime());
    	} else {
    	    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
    	}

    	// Get geolocation in Russian** for IP address (1.1.1.1) and all fields
    	GeolocationParams geoParams2 = new GeolocationParams();
    	geoParams2.setIPAddress("1.1.1.1");
    	geoParams2.setLang("ru");

    	Geolocation geolocation2 = api.getGeolocation(geoParams);

    	// Check if geolocation lookup was successful
    	if(geolocation2.getStatus() == 200) {
    	    System.out.println(geolocation2.getIPAddress());
    	    System.out.println(geolocation2.getCountryName());
    	} else {
    	    System.out.printf("Status Code: %d, Message: %s\n", geolocation2.getStatus(), geolocation2.getMessage());
    	}

    	// Get geolocation for the calling machine's IP address for all fields
    	Geolocation geolocation3 = api.getGeolocation();

    	if(geolocation3.getStatus() == 200) {
    	    System.out.println(geolocation3.getCountryCode2());
    	    System.out.println(geolocation3.getTimezone().getCurrentTime());
    	} else {
    	    System.out.printf("Status Code: %d, Message: %s\n", geolocation3.getStatus(), geolocation3.getMessage());
    	}
    	
    	Geolocation geolocation = api.getGeolocation();

    	if(geolocation.getStatus() == 200) {
    	    System.out.println(geolocation.getCountryCode2());
    	    System.out.println(geolocation.getTimezone().getCurrentTime());
    	} else {
    	    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
    	}*/
    }

}
