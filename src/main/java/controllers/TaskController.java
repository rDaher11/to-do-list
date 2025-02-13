package controllers;

import exceptions.TaskNotFoundException;
import models.RepositoryType;
import models.Status;
import models.Task;
import services.ITaskService;
import views.ITaskView;

import java.io.IOException;

public class TaskController {
    ITaskService taskService;
    ITaskView taskView ;
    private RepositoryType repositoryType = RepositoryType.JSON;
    public TaskController(ITaskService taskService ,ITaskView taskView) {
        this.taskService = taskService;
        this.taskView = taskView ;

    }
    public void addTask(Task task) {
        try {
            taskService.addTask(task);
            taskView.success("Task added successfully (ID: " + taskService.getLastId() + ")");
        } catch (RuntimeException e) {
            taskView.error(e.getMessage());
        }
    }
    public void updateTask(Integer currentId ,String description) {
        try {
            taskService.editTask(currentId,description);
        } catch (TaskNotFoundException e) {
            taskView.error(e.getMessage());
        }
    }
    public void deleteTask(Integer currentId) {
        try {
            taskService.deleteTask(currentId);
        } catch (TaskNotFoundException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void changeTaskStatus(Integer currentId, Status status) {
        try {
            taskService.changeTaskStatus(currentId,status);
        } catch (RuntimeException e) {
            taskView.error(e.getMessage());
        }
    }
    public void listAllTasks() {
        try {
            for (Task task : taskService.listAllTasks() )  {
                taskView.info(task.toString());
            }
        } catch (RuntimeException e) {
            taskView.error(e.getMessage());
        }
    }
    public void listAllTasksStatus (Status status) {
        try {
            for (Task task : taskService.listAllTaskStatus(status)) {
                taskView.info(task.toString());
            }
        } catch (RuntimeException e) {
            taskView.error(e.getMessage());
        }
    }
    public Integer getLastId() {
        return taskService.getLastId();
    }

    public void sync()  {
        try {
            taskService.saveAs(repositoryType);
        } catch (IOException e) {
            taskView.error("File error : " + e.getMessage() );
        }
    }

    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(RepositoryType repositoryType) {
        this.repositoryType = repositoryType;
    }
}
