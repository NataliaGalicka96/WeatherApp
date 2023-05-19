package weatherapp.controller;


public abstract class BaseController {

    private String fxmlName;

    public BaseController(/*WeatherManager weatherManager, ViewFactory viewFactory, */String fxmlName) {
      //  this.weatherManager = weatherManager;
       // this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }

}
