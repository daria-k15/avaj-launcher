package edu.school.project;

import edu.school.project.exception.AvajLauncherException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1 || args[0] == null){
            throw new AvajLauncherException("Put scenario file as argument!");
        }
    }
}
