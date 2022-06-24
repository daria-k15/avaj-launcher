package edu.school.project.aviation;

import edu.school.project.Logger;
import edu.school.project.tower.Tower;
import edu.school.project.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    int[][] weatherRules = {{2, 0, 4}, {0, 0, 5}, {0, 0, -3}, {0, 0, -15}};

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int index = weatherTower.getWeather(coordinates);
        coordinates.updateCoordinates(weatherRules[index]);
        Logger.logConditions(this, weatherTower.getWeather(coordinates));
    }

    @Override
    public void registerTower(Tower tower) {
        this.weatherTower = (WeatherTower) tower;
    }

    @Override
    public String toString(){
        return "Baloon#" + name + "(" + id + ")";
    }
}
