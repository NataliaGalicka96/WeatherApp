package weatherapp.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import weatherapp.WeatherManager;
import weatherapp.view.ViewFactory;

public class CurrentWeatherController extends BaseController{

    @FXML
    private VBox body;

    @FXML
    private Label currentCity;

    @FXML
    private Label currentDate;

    @FXML
    private Label currentDegree11;

    @FXML
    private Label currentHumidity;

    @FXML
    private ImageView currentPicture1;

    @FXML
    private Label currentPressure2;

    @FXML
    private Label currentTime;

    @FXML
    private Label currentWindSpeed;

    @FXML
    private Label description;

    @FXML
    private Label nextDayName;

    @FXML
    private Label nextDayName1;

    @FXML
    private Label nextDayName11;

    @FXML
    private Label nextDayName111;

    @FXML
    private Label nextDayName1111;

    @FXML
    private ImageView pictureNextDay;

    @FXML
    private ImageView pictureNextDay1;

    @FXML
    private ImageView pictureNextDay11;

    @FXML
    private ImageView pictureNextDay111;

    @FXML
    private ImageView pictureNextDay1111;

    @FXML
    private Label sensedTemperature;

    @FXML
    private Label temperatureNextDay;

    @FXML
    private Label temperatureNextDay1;

    @FXML
    private Label temperatureNextDay11;

    @FXML
    private Label temperatureNextDay111;

    @FXML
    private Label temperatureNextDay1111;

    @FXML
    private Label temperatureNextNight;

    @FXML
    private Label temperatureNextNight1;

    @FXML
    private Label temperatureNextNight11;

    @FXML
    private Label temperatureNextNight111;

    @FXML
    private Label temperatureNextNight1111;

    public CurrentWeatherController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }
}
