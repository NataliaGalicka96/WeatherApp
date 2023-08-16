package weatherapp.model.client;

import org.junit.jupiter.api.Test;
import weatherapp.model.client.OpenWeatherMapClient;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenWeatherMapClientTest {

    @Test
    void testIsNightTemperature() {
        // Arrange
        OpenWeatherMapClient owmClient = new OpenWeatherMapClient();

        // Act & Assert
        assertTrue(owmClient.isNightTemperature(22));
        assertTrue(owmClient.isNightTemperature(0));
        assertFalse(owmClient.isNightTemperature(12));
        assertFalse(owmClient.isNightTemperature(18));
    }
}