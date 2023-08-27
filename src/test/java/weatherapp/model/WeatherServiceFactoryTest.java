package weatherapp.model;

import org.junit.jupiter.api.Test;

import weatherapp.model.client.OpenWeatherMapClient;
import weatherapp.model.client.WeatherClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherServiceFactoryTest {
    


    @Test
    void testCreateWeatherClient() {
        //given
        WeatherClient weatherClient = WeatherServiceFactory.createWeatherClient();

        //then
        assertEquals(OpenWeatherMapClient.class, weatherClient.getClass());
        assertThat(weatherClient.getClass(), equalTo(OpenWeatherMapClient.class));
    }
}

/*
Sprawdzamy, czy metoda createWeatherCLient() zwraca oczekiwany typ klasy OpenWeatherMapClient
*/