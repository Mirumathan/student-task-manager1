import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name, String priority, String dueDate) {
        tasks.add(new Task(name, priority, dueDate));
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nYour Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            displayTask(i, tasks.get(i));
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
                displayTask(i, task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching task found.");
        }
    }

    public void filterByStatus(String status) {
        boolean found = false;

        System.out.println("\n" + status + " Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (task.getStatus().equalsIgnoreCase(status)) {
                displayTask(i, task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No " + status.toLowerCase() + " tasks found.");
        }
    }

    public void filterByPriority(String priority) {
        boolean found = false;

        System.out.println("\n" + priority + " Priority Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (task.priority.equalsIgnoreCase(priority)) {
                displayTask(i, task);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                "No " + priority.toLowerCase() + " priority tasks found."
            );
        }
    }

    public void showStatistics() {

        int total = tasks.size();
        int completed = 0;
        int pending = 0;
        int high = 0;
        int medium = 0;
        int low = 0;

        for (Task task : tasks) {

            if (task.completed) {
                completed++;
            } else {
                pending++;
            }

            if (task.priority.equalsIgnoreCase("High")) {
                high++;
            } else if (task.priority.equalsIgnoreCase("Medium")) {
                medium++;
            } else if (task.priority.equalsIgnoreCase("Low")) {
                low++;
            }
        }

        System.out.println("\n===== Task Statistics =====");
        System.out.println("Total Tasks     : " + total);
        System.out.println("Completed Tasks : " + completed);
        System.out.println("Pending Tasks   : " + pending);
        System.out.println("High Priority   : " + high);
        System.out.println("Medium Priority : " + medium);
        System.out.println("Low Priority    : " + low);
    }

    private void displayTask(int index, Task task) {
        System.out.println(
            (index + 1) + ". " +
            task.name +
            " | Priority: " +
            task.priority +
            " | Due: " +
            task.dueDate +
            " | Status: " +
            task.getStatus()
        );
    }
}