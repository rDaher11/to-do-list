package exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String massage){
        super("Task not found exception " + massage);
    }
}
