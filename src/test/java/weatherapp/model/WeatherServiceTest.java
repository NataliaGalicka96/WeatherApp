package weatherapp.model;



import org.junit.jupiter.api.Test;
import weatherapp.model.client.WeatherClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WeatherServiceTest {

    @Test
    void testConstructorAndGetWeatherClient() {
        // Arrange
        WeatherClient weatherClientMock = mock(WeatherClient.class);

        // Act
        WeatherService weatherService = new WeatherService(weatherClientMock);

        // Assert
        assertEquals(weatherClientMock, weatherService.getWeatherClient());
    }
}
