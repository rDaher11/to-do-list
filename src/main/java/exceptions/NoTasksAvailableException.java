package exceptions;

public class NoTasksAvailableException extends RuntimeException{
    public NoTasksAvailableException(String massage) {
        super("No Task Available Exception "+ massage);
    }
}
