package weatherapp.model;

import weatherapp.model.client.WeatherClient;

public class WeatherService {
	
	private final WeatherClient weatherClient;

	public WeatherService(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}
	
	public WeatherClient getWeatherClient() {
		return weatherClient;
	}

}
