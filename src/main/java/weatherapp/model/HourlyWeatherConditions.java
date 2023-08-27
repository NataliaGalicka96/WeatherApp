package weatherapp.model;

import net.aksingh.owmjapis.model.param.WeatherData;

public class HourlyWeatherConditions extends WeatherBase {

    private final int temperature;

    public HourlyWeatherConditions(WeatherData dayWeather, int dayTemperature) {
        super(dayWeather.getDateTime(), dayWeather.getMainData().getPressure(), dayWeather.getWeatherList().get(0).getIconLink());
        this.temperature = dayTemperature;
    }

    public String getTemperature() {
        return temperature + "\u00b0";
    }

    public int getHourlyTemperature() {
        return temperature;
    }
}

