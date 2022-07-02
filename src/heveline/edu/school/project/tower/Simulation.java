package heveline.edu.school.project.tower;

import heveline.edu.school.project.Logger;

import java.io.IOException;

public class Simulation {
    public static void startSimulation(WeatherTower weatherTower){
        while (weatherTower.duration-- > 0){
            weatherTower.changeWeather();
            weatherTower.changeCondition();
        }
        try {
            Logger.myStream.close();
        } catch (IOException e){
        }
    }
}
