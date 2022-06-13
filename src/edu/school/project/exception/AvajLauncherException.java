package edu.school.project.exception;

public class AvajLauncherException extends RuntimeException {
    public AvajLauncherException(String message) {
        super(message);
    }

    public AvajLauncherException(Throwable message) {
        super(message);
    }
}
