public class Task {

    String name;
    boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public void markCompleted() {
        completed = true;
    }

    public String getStatus() {
        return completed ? "Completed" : "Pending";
    }
}