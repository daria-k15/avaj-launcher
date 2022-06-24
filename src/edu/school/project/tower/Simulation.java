package edu.school.project.tower;

import edu.school.project.Logger;

public class Simulation {
    public static void startSimulation(WeatherTower weatherTower){
        Logger logger = new Logger();
        while (weatherTower.duration-- > 0){
            weatherTower.changeWeather();
            weatherTower.changeCondition();
        }
    }
}
