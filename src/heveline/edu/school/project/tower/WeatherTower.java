package heveline.edu.school.project.tower;

import heveline.edu.school.project.aviation.Coordinates;

public class WeatherTower extends Tower {
    WeatherProvider weatherProvider;

    public WeatherTower( String filePath){
        super.initTower(filePath);
        weatherProvider = weatherProvider.getWeatherProvider();
        setTower(this);
    }

    public int getWeather(Coordinates coordinates){
        return weatherProvider.getCurrentWeather(coordinates);
    }

    protected void changeWeather(){
        weatherProvider.changeWeather();
    }
}
