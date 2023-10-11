package weatherapp.model;


import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CityHandlerTest {

	@Test
    void shouldBeAbleToLoadCitiesFromValidFile() throws IOException {

        //given
        CityHandler cityHandler = new CityHandler();
        Map<String, Integer> citiesMap = new TreeMap<>();

        //when
        citiesMap = cityHandler.getCityListFromJsonFile("city.list.min.json");

        //then
        assertThat(citiesMap.size(), greaterThan(0));
        
    }

}