/// BY : D@HER

import controllers.TaskController;
import repositories.InMemoryTaskRepository;
import repositories.TaskRepository;
import services.ITaskService;
import services.TaskService;
import utils.CommandParser;
import views.ITaskView;
import views.StandardOutputTaskView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to To-Do list App");
        int counter = 2 ;
        while (counter != 0) {
            Scanner sc = new Scanner(System.in) ;
            String input = sc.nextLine() ;
            ITaskView taskView = new StandardOutputTaskView() ;
            TaskRepository taskRepository = new InMemoryTaskRepository();
            ITaskService taskService = new TaskService(taskRepository) ;
            TaskController taskController = new TaskController(taskService,taskView) ;
            CommandParser commandParser = new CommandParser(taskController) ;
            commandParser.parser(input.toString());
            taskController.sync();
            counter--;
        }
    }
}
