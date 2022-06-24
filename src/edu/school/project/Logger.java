package edu.school.project;

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
    }
    private void
}
