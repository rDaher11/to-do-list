package repositories;

import exceptions.NoTasksAvailableException;
import exceptions.TaskNotFoundException;
import models.Status;
import models.Task;

import java.util.List;

public interface TaskRepository {
    public void saveTask(Task newTask) ;
    public void deleteTask(Integer currentId) throws TaskNotFoundException;
    public void editTask(Integer currentId,String description) throws TaskNotFoundException;
    public boolean checkId(Integer currentId) ;
    public void changeTaskStatus(Integer currentId , Status status) throws TaskNotFoundException;
    public List<Task> listAllTasks() throws NoTasksAvailableException;
    public void changeAllTaskStatus(Status status) throws NoTasksAvailableException;
}
