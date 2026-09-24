import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name, String priority) {
        tasks.add(new Task(name, priority));
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nYour Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            System.out.println(
                (i + 1) + ". " +
                task.name +
                " | Priority: " +
                task.priority +
                " | Status: " +
                task.getStatus()
            );
        }
    }

    public void completeTask(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removed = tasks.remove(taskNumber - 1);
            System.out.println("Deleted task: " + removed.name);
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void searchTask(String keyword) {
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (task.name.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(
                    (i + 1) + ". " +
                    task.name +
                    " | Priority: " +
                    task.priority +
                    " | Status: " +
                    task.getStatus()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching task found.");
        }
    }
}