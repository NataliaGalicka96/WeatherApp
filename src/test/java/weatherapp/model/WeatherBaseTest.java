package weatherapp.model;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


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
	assertThat(dateString, equalTo("14:00"));

	}
	
	@Test
	void shouldReturnCorrectlyFormatOfDateTest() {
		
		//given
		//when
		String dateString = weatherBase.getDateToDailyForecast();
		
		//then
		assertThat(dateString, equalTo("Niedz., 13 sie"));
		
	}
	
	@Test
	void shouldReturnCorrectlyFormatOfPressureTest() {
		
		//given
		//when
		String pressureAfterFormat = weatherBase.getPressure();
		
		//then
		assertThat(pressureAfterFormat, equalTo("1005 hPa"));
		
	}
	
	@Test
	void shouldReturnHourFromDate() {
		//given
		//when
		int hour = weatherBase.getHour(date);
		//then
		assertThat(hour, equalTo(14));
	}
	
	@Test
	void shouldReturnMinuteFromDate() {
		//given
		//when
		int hour = weatherBase.getMinute(date);
		//then
		assertThat(hour, equalTo(0));
	}

}
