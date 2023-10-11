package weatherapp.model;

import net.aksingh.owmjapis.core.OWM;
import weatherapp.model.client.OWMClientConfig;
import weatherapp.model.client.OpenWeatherMapClient;
import weatherapp.model.client.WeatherClient;

/*
 * Klasa odpowiedzialna za tworzenie nowego klienta oraz nowego WeatherService
 * 
 * 
 */
public class WeatherServiceFactory {

	public static WeatherService createWeatherService()
	{
		return new WeatherService(createWeatherClient());
	}

	public static WeatherClient createWeatherClient() {
		return new OpenWeatherMapClient(new OWM(OWMClientConfig.OWM_API_KEY));
	}
	
}


