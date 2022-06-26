package heveline.edu.school.project.tower;

import heveline.edu.school.project.aviation.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private int seed;

    public static WeatherProvider getWeatherProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public int getCurrentWeather(Coordinates coordinates) {
        return (coordinates.mixCoordinates() / seed) % 4;
    }

    protected void changeWeather() {
        seed = (int) (Math.random() * 10) + 1;
    }
}
