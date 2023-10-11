package weatherapp.model;

import net.aksingh.owmjapis.model.param.Main;
import net.aksingh.owmjapis.model.param.Weather;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;

public class DailyWeatherConditionsTest {

    @Test
    void shouldSetCorrectlyValueForDailyWeather() {
        //given
    	Date date = new Date(123,7,13,14,0);
    	double pressure = 1013.2;
        String iconLink = "http://example.com/icon.png";
        int dayTemperature = 25;
        int nightTemperature = 18;

        WeatherData weatherDataMock = mock(WeatherData.class);
        Main mainDataMock = mock(Main.class);
        Weather weatherMock = mock(Weather.class);

        when(weatherDataMock.getDateTime()).thenReturn(date);
        when(weatherDataMock.getMainData()).thenReturn(mainDataMock);
        when(weatherDataMock.getWeatherList()).thenReturn(Collections.singletonList(weatherMock));
        when(mainDataMock.getPressure()).thenReturn(pressure);
        when(weatherMock.getIconLink()).thenReturn(iconLink);

        //when
        DailyWeatherConditions dailyWeatherConditions = new DailyWeatherConditions(weatherDataMock, dayTemperature, nightTemperature);

        //then

        assertEquals((int)pressure + " hPa", dailyWeatherConditions.getPressure());
        assertEquals(dayTemperature + "\u00b0" + "/" + nightTemperature + "\u00b0", dailyWeatherConditions.getTemperature());
    }
}