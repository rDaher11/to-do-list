package utils;

import controllers.TaskController;
import models.Status;
import models.Task;
import views.ITaskView;
import views.StandardOutputTaskView;

public class CommandParser {
    private final TaskController taskController;

    public CommandParser(TaskController taskController) {
        this.taskController = taskController;
    }
    public void parser(String input) {
        /*
        1.Reads user input
        2.Validates the command format
        3.Extracts necessary parameters (ID, status, description, etc.)
        4.Calls the correct method in TaskController
         */
        ITaskView taskView = new StandardOutputTaskView() ;
        String []parts = input.split(" " , 3) ;
        if (parts.length == 0) {
            taskView.error("Invalid command. Type 'task-cli help' for usage.");
            return;
        }
        String command = parts[0] ;
        switch (command) {
            case "add" :
                if (parts.length < 2) {
                    System.out.println("Usage: task-cli add \"task description\"");
                    return;
                }
                handelUpdate(parts);
                break;
            case "list" :
                if (parts.length == 1) {
                    taskController.listAllTasks();
                    break;
                } else if (parts.length == 2) {

                } else {
                    System.out.println("Usage: task-cli list Status");
                    return;
                }
            default:
                System.out.println("Unknown command: " + command);
        }
    }
    private void handelUpdate(String []parts) {
        /// remove quotes
        String description = parts[1].replace("\"" , "") ;
        taskController.addTask(new Task(taskController.getLastId()+1,description, Status.TODO));
    }

}
