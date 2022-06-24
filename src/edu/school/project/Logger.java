package edu.school.project;

import edu.school.project.aviation.Aircraft;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static Logger logger;
    private static Map<Integer, String> messages = new HashMap<>();
    private static Map<Integer, String> colors = new HashMap<>();

    public Logger(){
        if (logger != null){
            logger = new Logger();
        }
        initLogger();
        initColors();
    }
    private void initLogger(){
        messages.put(0, " * That's sunny day. Let's enjoy it!");
        messages.put(1, " 💦 Raining... Let's stay home.");
        messages.put(2, " 🌫 Can't see anything.");
        messages.put(3, " ❄️ It's snowing. We're gonna crash.");
    }

    private void initColors() {
        colors.put(0, "\033[1;33m");
        colors.put(1, "\033[1;34m");
        colors.put(2, "\033[1;37m");
        colors.put(3, "\033[1;30m");
        colors.put(4, "\033[0m");
    }

    public static void logConditions(Aircraft aircraft, int weatherIndex){
        System.out.println(colors.get(weatherIndex) + aircraft.toString() + messages.get(weatherIndex) + colors.get(4));
    }
}
