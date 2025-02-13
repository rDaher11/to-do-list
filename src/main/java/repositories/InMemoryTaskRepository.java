package repositories;

import exceptions.NoTasksAvailableException;
import exceptions.TaskNotFoundException;
import models.RepositoryType;
import models.Status;
import models.Task;
import utils.JsonOperations;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTaskRepository implements TaskRepository{
    private static List<Task> taskList = new ArrayList<>() ;
    private static Integer counterId;
    private final String FILEPATH = "src/main/resources/tasks.json" ;
    public InMemoryTaskRepository() {
        loadJsonFile(FILEPATH);
        counterId = taskList.size() + 1 ;
    }

    public static Integer getCounterId() {
        return counterId;
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public String getFILEPATH() {
        return FILEPATH;
    }

    @Override
    public void saveTask(Task newTask) {
        taskList.add(newTask);
    }

    @Override
    public void deleteTask(Integer currentId) throws TaskNotFoundException{
        if (checkId(currentId)) {
            taskList.removeIf(task -> task.getId().equals(currentId));
        } else {
            throw new TaskNotFoundException("Task with id" +currentId + "not found") ;
        }
    }

    @Override
    public void editTask(Integer currentId, String description) throws TaskNotFoundException {
        if(checkId(currentId)) {
            taskList.stream()
                    .filter(task -> task.getId().equals(currentId))
                    .findFirst()
                    .ifPresent(task -> {
                        task.setDescription(description);
                        task.setUpdateAt(LocalDate.now());
                    })
            ;
        } else {
            throw new TaskNotFoundException("Task with id" +currentId + "not found") ;
        }
    }

    @Override
    public boolean checkId(Integer currentId) {
        return taskList.stream().anyMatch(task -> task.getId().equals(currentId)) ;
    }

    @Override
    public void changeTaskStatus(Integer currentId, Status status) throws TaskNotFoundException {
        if (checkId(currentId)) {
            taskList.stream()
                    .filter(task -> task.getId().equals(currentId))
                    .findFirst()
                    .ifPresent(task -> {
                        task.setStatus(status);
                        task.setUpdateAt(LocalDate.now());
                    });
        } else {
            throw new TaskNotFoundException("Task with id " +currentId + "not found") ;
        }
    }

    @Override
    public List<Task> listAllTasks() throws NoTasksAvailableException {
        if (taskList.isEmpty()) {
            throw new NoTasksAvailableException("No tasks available.") ;
        }
        return taskList;
    }

    @Override
    public List<Task> listAllTaskStatus(Status status) {
        if(taskList.isEmpty()) {
            throw new NoTasksAvailableException("No tasks available.") ;
        }
        List<Task> specificTasks = taskList.parallelStream().
                filter(task -> task.getStatus().equals(status)).
                toList();
        if (specificTasks.isEmpty()) {
            throw new NoTasksAvailableException("No tasks available.") ;
        }
        return specificTasks;
    }

    @Override
    public Integer getLastId() {
        return taskList.size();
    }


    @Override
    public void saveAs (RepositoryType repositoryType) throws IOException {
        switch (repositoryType) {
            case JSON :
                JsonOperations.saveListOfTasks(taskList,new File(FILEPATH));
                break;
        }
    }

    public File creatFile(String filePath) throws IOException{
        File file = new File(filePath) ;
        if (!file.exists()) {
            boolean isFileCreated =  file.createNewFile();
            if (isFileCreated) {
                return file ;
            } else {
                throw new IOException("A problem happened with creating file") ;
            }
        }
        // file already exists
        return file;
    }


    public void loadJsonFile(String filePath) {
        try {
            File jsonFile = creatFile(filePath) ;
            if(jsonFile.length() > 0) {
                taskList = JsonOperations.readListOfTasks(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
