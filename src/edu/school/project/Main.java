package edu.school.project;

import edu.school.project.exception.AvajLauncherException;
import edu.school.project.tower.Simulation;
import edu.school.project.tower.WeatherTower;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1 || args[0] == null){
            throw new AvajLauncherException("Put scenario file as argument!");
        }
        Simulation.startSimulation(new WeatherTower(args[0]));
    }
}
