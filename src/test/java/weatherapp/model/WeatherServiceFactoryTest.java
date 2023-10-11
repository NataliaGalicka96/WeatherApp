package weatherapp.model;

import org.junit.jupiter.api.Test;

import weatherapp.model.client.OpenWeatherMapClient;
import weatherapp.model.client.WeatherClient;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WeatherServiceFactoryTest {


    /*
    Sprawdzamy, czy metoda createWeatherCLient() zwraca oczekiwany typ klasy OpenWeatherMapClient
    */

    @Test
    void shouldReturnOpenWeatherMapClientObject() {
        //given
        WeatherClient weatherClient = WeatherServiceFactory.createWeatherClient();

        //then
        assertEquals(OpenWeatherMapClient.class, weatherClient.getClass());
        assertThat(weatherClient.getClass(), equalTo(OpenWeatherMapClient.class));
    }


    /*
    Sprawdzamy, czy metoda getWeatherService w klasie WeatherService
    zwraca oczekiwany obiekt - obiekt klasy WeatherClient (klienta)
     */
    @Test
    public void shouldReturnWeatherClientObject() {
        //given
        WeatherClient mockClient = mock(WeatherClient.class);
        WeatherService weatherService = new WeatherService(mockClient);

        //when
        WeatherClient serviceClient = weatherService.getWeatherClient();

        //then
        assertSame(mockClient, serviceClient);
    }

    /*
    Metoda sprawdzająca, czy createWeatherService() z fabryki WeatherServiceFactory
    zwraca instancję OpenWeatherMapClient z odpowiednim klientem.

     */
    @Test
    public void shouldReturnInstanceOfOpenWeatherMapClientWithClient() {
        //given
        WeatherService weatherService = WeatherServiceFactory.createWeatherService();
        WeatherClient serviceClient = weatherService.getWeatherClient();

        //then
        assertTrue(serviceClient instanceof OpenWeatherMapClient);
    }

}