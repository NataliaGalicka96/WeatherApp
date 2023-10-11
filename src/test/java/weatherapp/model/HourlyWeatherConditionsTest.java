package weatherapp.model;

import net.aksingh.owmjapis.model.param.Main;
import net.aksingh.owmjapis.model.param.Weather;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;
import java.util.Date;

public class HourlyWeatherConditionsTest {

    @Test
    void shouldSetCorrectlyValueForHourlyWeather() {

    	//given
    	Date date = new Date(123,7,13,14,0);
        double pressure = 1013.2;
        int temperature = 25;
        String iconLink = "http://example.com/icon.png";

        WeatherData weatherDataMock = mock(WeatherData.class);
        Main mainDataMock = mock(Main.class);
        Weather weatherMock = mock(Weather.class);


        when(weatherDataMock.getDateTime()).thenReturn(date);
        when(weatherDataMock.getMainData()).thenReturn(mainDataMock);
        when(weatherDataMock.getWeatherList()).thenReturn(Collections.singletonList(weatherMock));
        when(mainDataMock.getPressure()).thenReturn(pressure);
        when(weatherMock.getIconLink()).thenReturn(iconLink);
        
        //when
        HourlyWeatherConditions hourlyWeatherConditions = new HourlyWeatherConditions(weatherDataMock, temperature);

        //then
        assertThat(hourlyWeatherConditions.getTemperature(), equalTo(temperature + "\u00b0"));
        assertThat(hourlyWeatherConditions.getPressure(), equalTo((int)pressure + " hPa"));
        
    }
}
