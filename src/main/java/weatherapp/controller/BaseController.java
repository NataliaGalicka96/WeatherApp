package weatherapp.controller;

import weatherapp.WeatherManager;
import weatherapp.view.ViewFactory;

public abstract class BaseController {
    private WeatherManager weatherManager;

    public String getFxmlName() {
        return fxmlName;
    }

    private ViewFactory viewFactory;

    private String fxmlName;

    public BaseController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        this.weatherManager = weatherManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }
}
