package weatherapp.controller;

import weatherapp.model.WeatherManager;
import weatherapp.view.ViewFactory;

public abstract class BaseController {
    private WeatherManager weatherManager;

    private ViewFactory viewFactory;

    private String fxmlName;

    public BaseController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        this.weatherManager = weatherManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }
}
