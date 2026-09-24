public class Task {

    String name;
    boolean completed;
    String priority;
    String dueDate;

    public Task(String name, String priority, String dueDate) {
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public void markCompleted() {
        completed = true;
    }

    public String getStatus() {
        return completed ? "Completed" : "Pending";
    }
}