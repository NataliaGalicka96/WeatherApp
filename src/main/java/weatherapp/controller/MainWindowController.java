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

public class MainWindowController {

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

        @FXML
        void searchAnotherPlace(ActionEvent event) {

        }

        @FXML
        void searchCurrentPlace(ActionEvent event) {

        }

        public Region mainBackground;
        public void initialize() {
            DoubleProperty xPosition = new SimpleDoubleProperty(0);
            xPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(mainBackground, xPosition.get()));
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(xPosition, 0)),
                    new KeyFrame(Duration.seconds(500), new KeyValue(xPosition, -15000))
            );
            timeline.play();
        }
        void setBackgroundPositions(Region region, double xPosition) {
            String style = "-fx-background-position: " +
                    "left " + xPosition/6 + "px bottom," +
                    "left " + xPosition/5 + "px bottom," +
                    "left " + xPosition/4 + "px bottom," +
                    "left " + xPosition/3 + "px bottom," +
                    "left " + xPosition/2 + "px bottom," +
                    "left " + xPosition + "px bottom;";
            region.setStyle(style);
        }

    }
