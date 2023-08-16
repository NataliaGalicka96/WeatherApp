package weatherapp.model;


import org.junit.jupiter.api.Test;

import weatherapp.model.client.OpenWeatherMapClient;
import weatherapp.model.client.WeatherClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherServiceFactoryTest {

	/*
    @Test
    void testCreateWeatherService() {
        // Arrange
        WeatherClient weatherClientMock = mock(WeatherClient.class);
        WeatherServiceFactory weatherServiceFactorySpy = spy(new WeatherServiceFactory());

        // Symulowanie zachowania metody createWeatherClient()
        doReturn(weatherClientMock).when(weatherServiceFactorySpy).createWeatherClient();

        // Act
        WeatherService weatherService = weatherServiceFactorySpy.createWeatherService();

        // Assert
        assertEquals(weatherClientMock, weatherService.getWeatherClient());
    }
    
    */

    @Test
    void testCreateWeatherClient() {
        // Act
        WeatherClient weatherClient = WeatherServiceFactory.createWeatherClient();

        // Assert
        assertEquals(OpenWeatherMapClient.class, weatherClient.getClass());
    }
}