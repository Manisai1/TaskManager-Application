public class Task {
    private String name;
    private int priority;
    private String description;
    private String category;
    private boolean completed;

    public Task(String name, int priority, String description, String category) {
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.category = category;
        this.completed = false;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return String.format("Task: %s, Priority: %d, Description: %s, Category: %s, Status: %s",
                name, priority, description, category, completed ? "Completed" : "In Progress");
    }
}