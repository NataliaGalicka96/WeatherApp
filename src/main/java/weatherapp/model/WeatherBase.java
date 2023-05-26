package weatherapp.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

public class WeatherBase {
	
	private static final Locale loc = new Locale("pl", "PL");
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("E, dd MMM", loc);

    protected Date date;

    private final double pressure;

    private final String iconUrl;

    public WeatherBase(Date timestamp, double pressure, String iconUrl) {
        this.date = timestamp;
        this.pressure = pressure;
        this.iconUrl = iconUrl;
    }

    public String getDateToDailyForecast() {

        return DATE_FORMAT.format(date).substring(0, 1).toUpperCase() + DATE_FORMAT.format(date).substring(1);
        
    }
    
   
    public String getDateToHourlyForecast() {
    	int date1 = getHour(date);
        int date2 = getMinute(date);
    	return date1 + ":" + date2 + 0;
        
    }

    public String getPressure() {
        return (int) Math.round(pressure) + " hPa";
    }
    
    public String getIconUrl() {
        return iconUrl;
    }
    
    private int getHour(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getHour();
    }
    
    private int getMinute(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.getMinute();
    }
}
