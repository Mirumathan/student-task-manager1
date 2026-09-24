public class Task {

    String name;
    boolean completed;
    String priority;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.completed = false;
    }

    public void markCompleted() {
        completed = true;
    }

    public String getStatus() {
        return completed ? "Completed" : "Pending";
    }
}