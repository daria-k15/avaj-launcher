package edu.school.project;

import edu.school.project.aviation.Aircraft;
import edu.school.project.aviation.Flyable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static Logger logger;
    private static Map<Integer, String> messages = new HashMap<>();

    private static FileWriter myStream;
    public Logger(){
        if (logger != null){
            logger = new Logger();
        }
        initOutput();
        initLogger();
    }

    private void initOutput() {
        try {
            myStream = new FileWriter("simulation.txt");
        } catch (IOException e){
            System.out.println("Problem with creating file!");
        }
    }
    private void initLogger(){
        messages.put(0, " ☀ That's sunny day. Let's enjoy it!\n");
        messages.put(1, " 💦 Raining... Let's stay home.\n");
        messages.put(2, " 🌫 Can't see anything.\n");
        messages.put(3, " ❄️ It's snowing. We're gonna crash.\n");
    }

    public static void logConditions(Aircraft aircraft, int weatherIndex){
        try {
            myStream.write(aircraft.toString() + messages.get(weatherIndex));
        } catch (Exception e) {
            System.out.println("Cannot write to file");
        }
    }

    public static void logRegistration(Flyable flyable) {
        try {
            myStream.write("Tower registered: " + flyable.toString() + " to weather tower\n");
        } catch (Exception e){
            System.out.println("Cannot write registration to file");
        }
    }

}
