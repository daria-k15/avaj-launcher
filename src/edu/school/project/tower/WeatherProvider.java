package edu.school.project.tower;

import edu.school.project.aviation.Coordinates;

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
        int index = (coordinates.mixCoordinates() / seed) % 4;
        return index;
    }

    protected void changeWeather() {
        seed = (int) (Math.random() * 10) + 1;
    }
}
