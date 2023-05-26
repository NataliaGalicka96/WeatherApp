package weatherapp.model;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import weatherapp.Config;

public class OWMWeather {

	private final OWM weatherMap;

	public OWMWeather() {
		weatherMap = new OWM(Config.OWM_API_KEY);
		weatherMap.setUnit(OWM.Unit.METRIC);
		weatherMap.setLanguage(OWM.Language.POLISH);
	}
	
	public CurrentWeather getCurrentWeather(String cityName) throws APIException {
		return weatherMap.currentWeatherByCityName(cityName);
	}
	
    public HourlyWeatherForecast getHourlyWeather(String cityName) throws APIException {
        return weatherMap.hourlyWeatherForecastByCityName(cityName);
    }
}
