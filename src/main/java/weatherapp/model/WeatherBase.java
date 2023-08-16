package weatherapp.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

public class WeatherBase {
	
	private static final Locale LOCALE = new Locale("pl", "PL");
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("E, dd MMM", LOCALE);

    private final Date date;
    private final double pressure;
    private final String iconUrl;
    
    public WeatherBase(Date timestamp, double pressure) {
    	this(timestamp, pressure, null);
    }

    public WeatherBase(Date timestamp, double pressure, String iconUrl) {
        this.date = timestamp;
        this.pressure = pressure;
        this.iconUrl = iconUrl;
    }

    public String getDateToDailyForecast() {
        return capitalizeFirstLetter(DATE_FORMAT.format(date));
    }
    
    public String getDateToHourlyForecast() {
    	return String.format("%02d:%02d", getHour(date), getMinute(date));
    }

    public String getPressure() {
        return (int) Math.round(pressure) + " hPa";
    }
    
    public String getIconUrl() {
        return iconUrl;
    }
    
    int getHour(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getHour();
    }
    
    int getMinute(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getMinute();
    }
    
    private String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}





/*
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

public class WeatherBase {
	
	private static Locale loc = new Locale("pl", "PL");
	 
	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("E, dd MMM", loc);

    private Date date;

    private double pressure;

    private  String iconUrl;
    
    public WeatherBase(Date timestamp, double pressure){
    	  this.date = timestamp;
    	  this.pressure = pressure;
    }


    public WeatherBase(Date timestamp, double pressure, String iconUrl) {
        this.date = timestamp;
        this.pressure = pressure;
        this.iconUrl = iconUrl;
    }

    public String getDateToDailyForecast() {

        return DATE_FORMAT.format(date).substring(0, 1).toUpperCase() + DATE_FORMAT.format(date).substring(1);
        
    }
    
   
    public String getDateToHourlyForecast() {
    	int hour = getHour(date);
        int minute = getMinute(date);
    	return hour + ":" + minute + 0;
        
    }

    public String getPressure() {
    	System.out.print(pressure);
        return (int) Math.round(pressure) + " hPa";
    }
    
    public String getIconUrl() {
        return iconUrl;
    }
    
    public int getHour(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getHour();
    }
    
    public int getMinute(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getMinute();
    }
}

*/
