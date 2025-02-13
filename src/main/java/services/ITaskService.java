package services;

import exceptions.NoTasksAvailableException;
import exceptions.TaskNotFoundException;
import models.RepositoryType;
import models.Task;
import models.Status;

import java.io.IOException;
import java.util.List;

public interface ITaskService {
    public void addTask(Task newTask) ;
    public void deleteTask(Integer currentId) throws TaskNotFoundException ;
    public void editTask(Integer currentId , String description) throws TaskNotFoundException ;
    public void checkId(Integer currentId) ;
    public void changeTaskStatus(Integer currentId, Status status) throws TaskNotFoundException;
    public List<Task> listAllTasks() throws NoTasksAvailableException;
    public List<Task> listAllTaskStatus(Status status) throws  NoTasksAvailableException;
    public Integer getLastId();
    public void saveAs(RepositoryType repositoryType) throws IOException;
}
