package edu.school.project.tower;

import edu.school.project.aviation.Flyable;
import edu.school.project.exception.AvajLauncherException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

abstract public class Tower {
    int duration;
    String[] params;
    private LinkedList<Flyable> observes = new LinkedList<>();

    public void initTower(String filePath){
        try {
            Scanner scanner = new Scanner(new File(filePath));
        } catch(FileNotFoundException e){
            throw new AvajLauncherException("File not found!");
        }
    }

}
