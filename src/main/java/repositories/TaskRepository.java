package repositories;

import models.Status;
import models.Task;

import java.util.List;

public interface TaskRepository {
    public void saveTask(Task newTask);
    public void deleteTask(Integer currentId);
    public void editTask(Integer currentId,String description);
    public boolean checkId(Integer currentId) ;
    public void changeTaskStatus(Integer currentId , Status status) ;
    public List<Task> listAllTasks() ;
    public void changeAllTaskStatus(Status status) ;
}
