package services;

import models.Status;
import models.Task;
import repositories.TaskRepository;

import java.util.List;

public class TaskService {
    TaskRepository taskRepository ;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public void addTask(Task newTask) {
        this.taskRepository.saveTask(newTask);
    }
    public void deleteTask(Integer currentId) {
        this.taskRepository.deleteTask(currentId);
    }
    public void editTask(Integer currentId , String description) {
        this.taskRepository.editTask(currentId,description);
    }
    public void checkId(Integer currentId) {
        this.taskRepository.checkId(currentId);
    }
    public void changeTaskStatus(Integer currentId, Status status) {
        this.taskRepository.changeTaskStatus(currentId,status);
    }
    public List<Task> listAllTasks() {
        return taskRepository.listAllTasks();
    }
    public void changeAllTaskStatus(Status status) {
        this.taskRepository.changeAllTaskStatus(status);
    }
}
