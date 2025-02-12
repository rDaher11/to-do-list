
package services;

import exceptions.NoTasksAvailableException;
import exceptions.TaskNotFoundException;
import models.Status;
import models.Task;
import repositories.TaskRepository;

import java.util.List;

public class TaskService implements ITaskService {
    TaskRepository taskRepository ;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public void addTask(Task newTask)  {
        this.taskRepository.saveTask(newTask);
    }
    @Override
    public void deleteTask(Integer currentId) throws TaskNotFoundException {
        this.taskRepository.deleteTask(currentId);
    }
    @Override
    public void editTask(Integer currentId , String description) throws TaskNotFoundException {
        this.taskRepository.editTask(currentId,description);
    }
    @Override
    public void checkId(Integer currentId) {
        this.taskRepository.checkId(currentId);
    }
    @Override
    public void changeTaskStatus(Integer currentId, Status status) throws TaskNotFoundException {
        this.taskRepository.changeTaskStatus(currentId,status);
    }
    @Override
    public List<Task> listAllTasks()throws NoTasksAvailableException {
        return taskRepository.listAllTasks();
    }
    @Override
    public List<Task> listAllTaskStatus(Status status) throws NoTasksAvailableException {
        return this.taskRepository.listAllTaskStatus(status);
    }
    @Override
    public Integer getLastId() throws NoTasksAvailableException{
        return this.taskRepository.getLastId();
    }

}
