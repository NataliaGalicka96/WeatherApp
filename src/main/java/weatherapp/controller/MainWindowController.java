package weatherapp.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import weatherapp.WeatherManager;
import weatherapp.view.ViewFactory;

public class MainWindowController extends BaseController {

        @FXML
        private Label anotherDescription;

        @FXML
        private TextField anotherPlace;

        @FXML
        private Label anotherPlaceDegree;

        @FXML
        private Label anotherPlaceHumidity;

        @FXML
        private Label currentDegree;

        @FXML
        private Label currentDescription;

        @FXML
        private TextField currentPlace;

        @FXML
        private Label currentPlaceHumidity;

        @FXML
        private Label currentTimeInAntoherPlace;

        @FXML
        private Label currentTimeInCurrentPlace;

        @FXML
        private ImageView imageWeatherOfAnotherPlace;

        @FXML
        private ImageView imageWeatherOfCurrentPlace;

        @FXML
        private Label namOfCurrentPlace;

        @FXML
        private Label nameOfAntoherPlace;

        @FXML
        private Label pressureAnotherPlace;

        @FXML
        private Label pressureCurrentPlace;

        @FXML
        private Label senseTemperatureAnother;

        @FXML
        private Label senseTemperatureCurrent;

        @FXML
        private Label title;

        @FXML
        private Label windAnotherPlace;

        @FXML
        private Label windCurrentPlace;

        public MainWindowController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
                super(weatherManager, viewFactory, fxmlName);
        }

        @FXML
        void searchAnotherPlace(ActionEvent event) {

        }

        @FXML
        void searchCurrentPlace(ActionEvent event) {

        }



    }
