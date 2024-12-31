import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authenticator authenticator = new Authenticator();
        TaskOperations taskOperations = new TaskOperations();
        CategoryOperations categoryOperations = new CategoryOperations();

        System.out.println("Enter your Username:");
        String username = scanner.nextLine();

        System.out.println("Enter your Password:");
        String password = scanner.nextLine();

        if (authenticator.authenticate(username, password)) {
            System.out.println("Authentication Successful: Welcome " + username);
            while (true) {
                System.out.println("\nTask Manager Menu:");
                System.out.println("1. Add a Category");
                System.out.println("2. List Categories");
                System.out.println("3. Add a Task");
                System.out.println("4. List Tasks");
                System.out.println("5. Mark a Task as Completed");
                System.out.println("6. Remove a Task");
                System.out.println("7. Search for a Task by Name");
                System.out.println("8. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter category name:");
                        String categoryName = scanner.nextLine();
                        categoryOperations.addCategory(categoryName);
                        break;
                    case 2:
                        categoryOperations.listCategories();
                        break;
                    case 3:
                        System.out.println("Enter task name:");
                        String taskName = scanner.nextLine();
                        System.out.println("Enter task priority (1-5):");
                        int priority = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter task description:");
                        String description = scanner.nextLine();
                        System.out.println("Enter task category:");
                        String taskCategory = scanner.nextLine();
                        if (categoryOperations.categoryExists(taskCategory)) {
                            taskOperations.addTask(new Task(taskName, priority, description, taskCategory));
                        } else {
                            System.out.println("Category not found. Please create the category first.");
                        }
                        break;
                    case 4:
                        taskOperations.listTasks();
                        break;
                    case 5:
                        System.out.println("Enter task name to mark as completed:");
                        String completeTaskName = scanner.nextLine();
                        try {
                            taskOperations.markTaskAsCompleted(completeTaskName);
                        } catch (TaskNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Enter task name to remove:");
                        String removeTaskName = scanner.nextLine();
                        try {
                            taskOperations.removeTask(removeTaskName);
                        } catch (TaskNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("Enter task name to search:");
                        String searchName = scanner.nextLine();
                        taskOperations.searchTaskByName(searchName).forEach(System.out::println);
                        break;
                    case 8:
                        System.out.println("Exiting Task Manager. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials. Exiting.");
        }
    }
}