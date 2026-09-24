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

    public Task(String name, String priority, String dueDate, boolean completed) {
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public void markPending() {
        completed = false;
    }

    public String getStatus() {
        return completed ? "Completed" : "Pending";
    }
}