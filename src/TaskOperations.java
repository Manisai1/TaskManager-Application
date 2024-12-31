import java.util.ArrayList;
import java.util.List;

public class TaskOperations {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        tasks.forEach(System.out::println);
    }

    public void markTaskAsCompleted(String taskName) throws TaskNotFoundException {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                task.markAsCompleted();
                return;
            }
        }
        throw new TaskNotFoundException("Task not found: " + taskName);
    }

    public void removeTask(String taskName) throws TaskNotFoundException {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                tasks.remove(task);
                return;
            }
        }
        throw new TaskNotFoundException("Task not found: " + taskName);
    }

    public List<Task> searchTaskByName(String name) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }
}