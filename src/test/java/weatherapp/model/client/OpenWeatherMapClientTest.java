package weatherapp.model.client;

import org.junit.jupiter.api.Test;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;
import net.aksingh.owmjapis.model.param.Wind;
import weatherapp.model.DailyWeatherConditions;
import weatherapp.model.HourlyWeatherConditions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.scene.control.Label;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import net.aksingh.owmjapis.model.param.Main;
import net.aksingh.owmjapis.model.param.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;


public class OpenWeatherMapClientTest {

	
	private OpenWeatherMapClient owmClient;
    private OWM owmMock;


    @BeforeAll
    public static void initJavaFX() {
        // Inicjalizacja JavaFX
        Platform.startup(() -> {});
    }
    
    @AfterAll
    public static void cleanupJavaFX() {
        // Zakończenie JavaFX
        Platform.exit();
    }

    @BeforeEach
    public void setUp() {
        owmMock = mock(OWM.class);
        owmClient = new OpenWeatherMapClient(owmMock);
    }

    /*
    Sprawdzenie czy metoda getWeather klasy owmClient poprawnie wywołuje metodę currentWeatherByCityName
    na obiekcie owmMock z odpowiednim argumentem, w tym przypadku z "Warszawa".
     */
    @Test
    public void verifyCallCurrentWeatherByCityName() throws APIException {
        //given
        TextField chooseLocation = new TextField();
        chooseLocation.setText("Warszawa");
        Label city = new Label();
        Label degree = new Label();
        Label humidity = new Label();
        ImageView picture = new ImageView();
        Label pressure = new Label();
        Label windSpeed = new Label();
        Label description = new Label();

        CurrentWeather mockCurrentWeather = new CurrentWeather();
        when(owmMock.currentWeatherByCityName("Warszawa")).thenReturn(mockCurrentWeather);

        //when
        owmClient.getWeather(chooseLocation, city, degree, humidity, picture, pressure, windSpeed, description);

        //then
        verify(owmMock).currentWeatherByCityName("Warszawa");
        
    }

    @Test
    public void shouldBeUpdateElementsOfUserInterface() throws APIException {
    	
    	//given
        TextField chooseLocation = new TextField("Warszawa");
        Label city = new Label();
        Label degree = new Label();
        Label humidity = new Label();
        ImageView picture = new ImageView();
        Label pressure = new Label();
        Label windSpeed = new Label();
        Label description = new Label();

        CurrentWeather currentWeatherMock = mock(CurrentWeather.class);
        when(owmMock.currentWeatherByCityName("Warszawa")).thenReturn(currentWeatherMock);
        when(currentWeatherMock.getCityName()).thenReturn("Warszawa");


        Main mainDataMock = mock(Main.class);
        when(mainDataMock.getTemp()).thenReturn(25.0); //Ustawienie przykładowej wartości temperatury
        when(mainDataMock.getPressure()).thenReturn(1009.2);
        when(mainDataMock.getHumidity()).thenReturn(34.9);

        when(currentWeatherMock.getMainData()).thenReturn(mainDataMock);

        List<Weather> weatherListMock = List.of(mock(Weather.class));
        when(currentWeatherMock.getWeatherList()).thenReturn(weatherListMock);

        Wind windDataMock = mock(Wind.class);
        when(windDataMock.getSpeed()).thenReturn(5.0); //Ustawienie przykładowej wartości prędkości wiatru
        when(currentWeatherMock.getWindData()).thenReturn(windDataMock);

        // Ustawić descriptionText jako null (może być mockiem lub null)
        when(weatherListMock.get(0).getMoreInfo()).thenReturn(null);

        Weather mockWeatherData = mock(Weather.class);
        when(currentWeatherMock.getWeatherList()).thenReturn(java.util.Arrays.asList(mockWeatherData));
        when(mockWeatherData.getMoreInfo()).thenReturn("cloudy"); //Ustawienie opisu pogody
        when(mockWeatherData.getIconLink()).thenReturn("https://example.com/cloudy.png"); // Ustawienie linku do ikony


        when(owmMock.currentWeatherByCityName("CityName")).thenReturn(currentWeatherMock);

        //when
        owmClient.getWeather(chooseLocation, city, degree, humidity, picture, pressure, windSpeed, description);
        
        
        //then

        assertEquals("Warszawa", city.getText());
        assertEquals("25°", degree.getText());
        assertEquals("Ciśnienie: 1009 hPa", pressure.getText());
        assertEquals("Wilgotność: 35 %", humidity.getText());
        assertEquals("Wiatr: 5 m/s", windSpeed.getText());
        assertEquals("Cloudy", description.getText());
        assertEquals("https://example.com/cloudy.png", picture.getImage().getUrl());
    }
    
    
	   /*
	   Sprawdzenie, czy metoda getDailyForecast zwraca pustą listę,
	   gdy odpowiedź jest inna niż "200"
	    */
    @Test
    public void getDailyForecastReturnsEmptyListWhenRespCodeIsNot200() throws APIException {

        //given
        HourlyWeatherForecast mockForecast = mock(HourlyWeatherForecast.class);
        when(mockForecast.hasRespCode()).thenReturn(false); // Ustawienie, że respCode nie jest 200
        when(owmMock.hourlyWeatherForecastByCityName(anyString())).thenReturn(mockForecast);

        //when
        List<DailyWeatherConditions> dailyForecast = owmClient.getDailyForecast("City");

        //then
        assertTrue(dailyForecast.isEmpty());
    }

    /*
    Sprawdzenie, czy metoda getDailyForecast zwraca pustą listę, gdy dane nie zostaną znalezione (są niedostępne)
     */
    @Test
    public void getDailyForecastReturnsEmptyListWhenNoDataAvailable() throws APIException {

        //given
        HourlyWeatherForecast mockForecast = mock(HourlyWeatherForecast.class);
        when(mockForecast.hasRespCode()).thenReturn(true);
        when(mockForecast.getRespCode()).thenReturn("200");
        when(mockForecast.getDataList()).thenReturn(new ArrayList<>()); // Brak dostępnych danych

        when(owmMock.hourlyWeatherForecastByCityName(anyString())).thenReturn(mockForecast);

        //when
        List<DailyWeatherConditions> dailyForecast = owmClient.getDailyForecast("City");

        //then
        assertTrue(dailyForecast.isEmpty());
    }


    @Test
    public void getHourlyForecast() throws Exception {

        //given
        String cityName = "Warszawa";

        HourlyWeatherForecast mockHourlyForecast = mock(HourlyWeatherForecast.class);
        when(owmMock.hourlyWeatherForecastByCityName(cityName)).thenReturn(mockHourlyForecast);

        List<WeatherData> mockDataList = new ArrayList<>();

        when(mockHourlyForecast.getDataList()).thenReturn(mockDataList);
        when(mockHourlyForecast.hasRespCode()).thenReturn(true);
        when(mockHourlyForecast.getRespCode()).thenReturn("200");

        //when
        List<HourlyWeatherConditions> hourlyWeatherConditionsList = owmClient.getHourlyForecast(cityName);

        //then
        assertNotNull(hourlyWeatherConditionsList);

    }
    
    @Test
    public void getDailyForecast() throws Exception {

        //given
        String cityName = "Warszawa";

        HourlyWeatherForecast mockHourlyForecast = mock(HourlyWeatherForecast.class);
        when(owmMock.hourlyWeatherForecastByCityName(cityName)).thenReturn(mockHourlyForecast);

        List<WeatherData> mockDataList = new ArrayList<>();

        when(mockHourlyForecast.getDataList()).thenReturn(mockDataList);
        when(mockHourlyForecast.hasRespCode()).thenReturn(true);
        when(mockHourlyForecast.getRespCode()).thenReturn("200");

        //when
        List<DailyWeatherConditions> dailyWeatherConditionsList = owmClient.getDailyForecast(cityName);

        //then
        assertNotNull(dailyWeatherConditionsList);
        assertTrue(dailyWeatherConditionsList.size() <= 10);
        

    }


    @Test
    void shouldNightTemperature() {
        
        //When
        //Then
        assertTrue(owmClient.isNightTemperature(22));
        assertTrue(owmClient.isNightTemperature(0));
        assertFalse(owmClient.isNightTemperature(12));
        assertFalse(owmClient.isNightTemperature(18));
    }
    
    @Test
    void shouldDayTemperature() {

        //When
        //Then
        assertFalse(owmClient.isDayTemperature(22));
        assertFalse(owmClient.isDayTemperature(0));
        assertTrue(owmClient.isDayTemperature(13));
        assertTrue(owmClient.isDayTemperature(15));
    }

    @Test
    public void shouldReturnDayOfWeekFromDate() throws ParseException {
        //given
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2023-10-06 12:00:00");
        DayOfWeek expectedDayOfWeek = DayOfWeek.FRIDAY;

        //when
        DayOfWeek actualDayOfWeek = owmClient.getDayOfWeek(date);

        //then
        assertEquals(expectedDayOfWeek, actualDayOfWeek);
    }

    @Test
    public void shouldReturnHourFromDate() throws ParseException {
        //given
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2023-10-06 15:30:45");
        int expectedHour = 15;

        //when
        int actualHour = owmClient.getHour(date);

        //then
        assertEquals(expectedHour, actualHour);
    }

}