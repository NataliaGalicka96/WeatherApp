package weatherapp.model;

import org.junit.jupiter.api.Test;
import weatherapp.model.client.WeatherClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherServiceTest {

    @Test
    void testConstructorAndGetWeatherClient() {
        //Given
        WeatherClient weatherClientMock = mock(WeatherClient.class);

        //When
        WeatherService weatherService = new WeatherService(weatherClientMock);

        //Then
        assertEquals(weatherClientMock, weatherService.getWeatherClient());
        assertThat(weatherService.getWeatherClient(), equalTo(weatherClientMock));
    }
}

/*
Testuję konstruktor oraz metodę getWeatherClient().
 
Tworzymy mocka klasy WeatherClient.
 
Tworzymy obiekt klasy weatherService (obiekt rzeczywisty).
 
Sprawdzamy czy metoda getWeatherClient() zwróci nam weatherClientMock.
 */

