(Task.java)
public class Task {
    private String description;
    private Priority priority;
    private boolean isComplete;

    public Task(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
        this.isComplete = false;
    }

    // Getters and setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}

-------------------------------------------------------------------------------------------------------------------------------------------

(Priority.java)
public enum Priority {
    HIGH,
    MEDIUM,
    LOW
}

-------------------------------------------------------------------------------------------------------------------------------------------

(TaskManagerView.java)
import java.util.List;
import java.util.Scanner;

public class TaskManagerView {
    private Scanner scanner;

    public TaskManagerView() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("Task Manager");
        System.out.println("1. Create Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Task List");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getTaskDescription() {
        System.out.print("Enter task description: ");
        return scanner.nextLine();
    }

    public Priority getTaskPriority() {
        System.out.println("Select task priority:");
        System.out.println("1. High");
        System.out.println("2. Medium");
        System.out.println("3. Low");
        System.out.print("Enter priority choice (1/2/3): ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return Priority.HIGH;
            case 2:
                return Priority.MEDIUM;
            case 3:
                return Priority.LOW;
            default:
                return Priority.LOW;
        }
    }

    public void displayTaskList(List<Task> tasks) {
        System.out.println("Task List:");
        for (Task task : tasks) {
            String status = task.isComplete() ? "Complete" : "Incomplete";
            System.out.println("[" + task.getPriority() + "] " + task.getDescription() + " - " + status);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

------------------------------------------------------------------------------------------------------------------------------------------

(TaskManagerController.java)
import java.util.ArrayList;
import java.util.List;

public class TaskManagerController {
    private List<Task> tasks;
    private TaskManagerView view;

    public TaskManagerController(TaskManagerView view) {
        tasks = new ArrayList<>();
        this.view = view;
    }

    public void start() {
        int choice;
        do {
            choice = view.showMenu();
            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    markTaskComplete();
                    break;
                case 3:
                    viewTaskList();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    private void createTask() {
        String description = view.getTaskDescription();
        Priority priority = view.getTaskPriority();
        Task task = new Task(description, priority);
        tasks.add(task);
        view.displayMessage("Task created successfully.");
    }

    private void markTaskComplete() {
        view.displayTaskList(tasks);
        int index = getIndexFromUser("Enter the index of the task to mark as complete: ");
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setComplete(true);
            view.displayMessage("Task marked as complete.");
        } else {
            view.displayMessage("Invalid task index.");
        }
    }

    private void viewTaskList() {
        view.displayTaskList(tasks);
    }

    private int getIndexFromUser(String message) {
        view.displayMessage(message);
        return Integer.parseInt(view.scanner.nextLine());
    }
}

-----------------------------------------------------------------------------------------------------------------------------------------

(Main.java)
public class Main {
    public static void main(String[] args) {
        TaskManagerView view = new TaskManagerView();
        TaskManagerController controller = new TaskManagerController(view);
        controller.start();
    }
}
