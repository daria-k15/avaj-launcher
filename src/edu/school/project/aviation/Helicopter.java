package edu.school.project.aviation;

import edu.school.project.tower.Tower;
import edu.school.project.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    WeatherTower weatherTower;
    int[][] weatherRules = {{10, 0, 2}, {5, 0, 0}, {1, 0, 0}, {0, 0, -12}};

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions(){
        int index = weatherTower.getWeather(coordinates);
        coordinates.updateCoordinates(weatherRules[index]);
    }

    @Override
    public void registerTower(Tower tower){
        this.weatherTower = (WeatherTower) tower;
    }

    @Override
    public String toString(){
        return "#" + name + "(" + id + ")";
    }
}
