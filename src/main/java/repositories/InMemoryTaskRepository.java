package repositories;

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
    public void deleteTask(Integer currentId) {
        if (checkId(currentId)) {
            taskList.removeIf(task -> task.getId().equals(currentId));
        } else {
            throw new RuntimeException("Wrong task id");
        }
    }

    @Override
    public void editTask(Integer currentId, String description) {
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
            throw new RuntimeException("Wrong task id") ;
        }
    }

    @Override
    public boolean checkId(Integer currentId) {
        return taskList.stream().anyMatch(task -> task.getId().equals(currentId)) ;
    }

    @Override
    public void changeTaskStatus(Integer currentId, Status status) {
        if (checkId(currentId)) {
            taskList.stream()
                    .filter(task -> task.getId().equals(currentId))
                    .findFirst()
                    .ifPresent(task -> {
                        task.setStatus(status);
                        task.setUpdateAt(LocalDate.now());
                    });
        } else {
            throw new RuntimeException("Wrong task id") ;
        }
    }

    @Override
    public List<Task> listAllTasks() {
        return getTaskList();
    }

    @Override
    public void changeAllTaskStatus(Status status) {
        taskList.parallelStream()
                .forEach(task -> {
                    task.setStatus(status);
                    task.setUpdateAt(LocalDate.now());
                });
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
