package weatherapp.view;

import weatherapp.model.WeatherManager;

public class ViewFactory {

    private WeatherManager weatherManager;

    public ViewFactory(WeatherManager weatherManager){
        this.weatherManager = weatherManager;
    }

    public void showMainWindow(){

    }
}
