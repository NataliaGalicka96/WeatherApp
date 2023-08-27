package weatherapp.model;

import net.aksingh.owmjapis.model.param.WeatherData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

public class DailyWeatherConditionsTest {

    @Test
    void testConstructorAndGetTemperature() {
        //given
    	Date date = new Date(123,7,13,14,0);
    	double pressure = 1013.2;
        int dayTemperature = 25;
        int nightTemperature = 18;

        WeatherData weatherDataMock = mock(WeatherData.class);


        when(weatherDataMock.getDateTime()).thenReturn(date);
        when(weatherDataMock.getMainData().getPressure()).thenReturn(pressure);


        //when
        DailyWeatherConditions dailyWeatherConditions = new DailyWeatherConditions(weatherDataMock, dayTemperature, nightTemperature);

        //then

        assertThat(dailyWeatherConditions.getTemperature(), equalTo(dayTemperature + "\u00b0" + "/" + nightTemperature + "\u00b0"));
        assertThat(dailyWeatherConditions.getDayTemperature(), equalTo(dayTemperature));
        assertThat(dailyWeatherConditions.getNightTemperature(), equalTo(nightTemperature));
        
        assertThat(dailyWeatherConditions.getPressure(), equalTo((int)pressure + " hPa"));
        
    }
}
