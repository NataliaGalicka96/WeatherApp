package weatherapp.model;

import net.aksingh.owmjapis.model.param.WeatherData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;

public class HourlyWeatherConditionsTest {

    @Test
    void testConstructorAndGetTemperature() {

    	//given
    	Date date = new Date(123,7,13,14,0);
        double pressure = 1013.2;
        int temperature = 25;

        WeatherData weatherDataMock = mock(WeatherData.class);

        when(weatherDataMock.getDateTime()).thenReturn(date);
        when(weatherDataMock.getMainData().getPressure()).thenReturn(pressure);

        //when
        HourlyWeatherConditions hourlyWeatherConditions = new HourlyWeatherConditions(weatherDataMock, temperature);

        //then

        assertThat(hourlyWeatherConditions.getTemperature(), equalTo(temperature + "\u00b0"));
        assertThat(hourlyWeatherConditions.getPressure(), equalTo((int)pressure + " hPa"));
        
    }
}
