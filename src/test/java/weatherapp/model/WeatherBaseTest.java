package weatherapp.model;

import static junit.framework.Assert.assertEquals;


import java.util.Date;
import org.junit.jupiter.api.Test;

public class WeatherBaseTest {
	

	Date date = new Date(123,7,13,14,0);
	
	Double pressure = 1005.00;
	
	WeatherBase weatherBase = new WeatherBase(date, pressure);
	
	
	@Test
	void shouldReturnHourAndMinuteFromDateTest() {
	
    //given
	//when
	String dateString = weatherBase.getDateToHourlyForecast();
	
	//then
	assertEquals(dateString, "14:00");

	}
	
	@Test
	void shouldReturnCorectlyFormatOfDateTest() {
		
		//given
		//when
		String dateString = weatherBase.getDateToDailyForecast();
		
		//then
		assertEquals(dateString, "Niedz., 13 sie");
		
	}
	
	@Test
	void shouldReturnCorectlyFormatOfPressureTest() {
		
		//given
		//when
		String pressureAfterFormat = weatherBase.getPressure();
		
		//then
		assertEquals(pressureAfterFormat, "1005 hPa");
		
	}
	
	@Test
	void shoulReturnHourFromDate() {
		//given
		//when
		int hour = weatherBase.getHour(date);
		//then
		assertEquals(hour, 14);
	}
	
	@Test
	void shouldReturnMinuteFromDate() {
		//given
		//when
		int hour = weatherBase.getMinute(date);
		//then
		assertEquals(hour, 0);
	}
	
	
	
	

}
