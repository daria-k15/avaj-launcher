package heveline.edu.school.project.aviation;

import heveline.edu.school.project.Logger;
import heveline.edu.school.project.tower.Tower;
import heveline.edu.school.project.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    int[][] weatherRules = {{0, 10, 2}, {0, 5, 0}, {0, 1, 0}, {0, 0, -7}};

    JetPlane(String name, Coordinates coordinates) {
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
        return "JetPlane" + "#" + name + "(" + id + ")";
    }
}
