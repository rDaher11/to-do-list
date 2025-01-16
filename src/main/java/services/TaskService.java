package services;

import models.Task;
import repositories.TaskRepository;

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
}
