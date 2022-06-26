package heveline.edu.school.project.tower;

public class Simulation {
    public static void startSimulation(WeatherTower weatherTower){
        while (weatherTower.duration-- > 0){
            weatherTower.changeWeather();
            weatherTower.changeCondition();
        }
    }
}
