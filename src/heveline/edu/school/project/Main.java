package heveline.edu.school.project;

import heveline.edu.school.project.exception.AvajLauncherException;
import heveline.edu.school.project.tower.Simulation;
import heveline.edu.school.project.tower.WeatherTower;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1 || args[0] == null){
            throw new AvajLauncherException("Put scenario file as argument!");
        }
        if (args[0].endsWith("scenario.txt") || args[0].endsWith("scenario.md5")){
            Logger logger = new Logger();
            Simulation.startSimulation(new WeatherTower(args[0]));
        } else {
            throw new AvajLauncherException("Invalid argument! File should be scenario.txt or scenario.md5");
        }
    }
}
