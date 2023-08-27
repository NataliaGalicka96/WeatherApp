package weatherapp.model.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenWeatherMapClientTest {

    @Test
    void testIsNightTemperature() {
        
    	//Given
        OpenWeatherMapClient owmClient = new OpenWeatherMapClient();

        //When
        //Then
        assertTrue(owmClient.isNightTemperature(22));
        assertTrue(owmClient.isNightTemperature(0));
        assertFalse(owmClient.isNightTemperature(12));
        assertFalse(owmClient.isNightTemperature(18));
    }
    
    @Test
    void testIsDayTemperature() {
        
    	//Given
        OpenWeatherMapClient owmClient = new OpenWeatherMapClient();

        //When
        //Then
        assertFalse(owmClient.isDayTemperature(22));
        assertFalse(owmClient.isDayTemperature(0));
        assertTrue(owmClient.isDayTemperature(13));
        assertTrue(owmClient.isDayTemperature(15));
    }
}