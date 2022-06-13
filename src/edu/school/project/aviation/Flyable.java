package edu.school.project.aviation;

import edu.school.project.tower.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower newWeatherTower);
}
