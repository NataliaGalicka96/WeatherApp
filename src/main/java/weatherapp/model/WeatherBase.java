package weatherapp.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class WeatherBase {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("E, MMM dd", new Locale("pl", "PL"));

    protected Date date;

    private final double pressure;

    private final String description;

    private final String iconUrl;

    public WeatherBase(Date timestamp, double pressure, String description, String iconUrl) {
        this.date = timestamp;
        this.pressure = pressure;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    public String getDate() {
        return DATE_FORMAT.format(date);
    }

    public String getPressure() {
        return pressure + "hPa";
    }

    public String getDescription() {
        return description;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
