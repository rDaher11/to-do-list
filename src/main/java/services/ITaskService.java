package services;

import exceptions.NoTasksAvailableException;
import exceptions.TaskNotFoundException;
import models.Task;
import models.Status;
import java.util.List;

public interface ITaskService {
    public void addTask(Task newTask) ;
    public void deleteTask(Integer currentId) throws TaskNotFoundException ;
    public void editTask(Integer currentId , String description) throws TaskNotFoundException ;
    public void checkId(Integer currentId) ;
    public void changeTaskStatus(Integer currentId, Status status) throws TaskNotFoundException;
    public List<Task> listAllTasks() throws NoTasksAvailableException;
    public void changeAllTaskStatus(Status status) throws  NoTasksAvailableException;
}
