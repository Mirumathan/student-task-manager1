import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    private final String fileName = "tasks.txt";

    private final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String name, String priority, String dueDate) {

        tasks.add(new Task(name, priority, dueDate));
        saveTasks();

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
            saveTasks();

            System.out.println("Task marked as completed!");

        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void deleteTask(int taskNumber) {

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {

            Task removed = tasks.remove(taskNumber - 1);
            saveTasks();

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
            System.out.println(
                    "No " + status.toLowerCase() + " tasks found."
            );
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

    public void sortByPriority() {

        tasks.sort(new Comparator<Task>() {

            @Override
            public int compare(Task first, Task second) {

                return getPriorityValue(first.priority)
                        - getPriorityValue(second.priority);
            }
        });

        System.out.println("\nTasks sorted by priority:");
        viewTasks();
    }

    private int getPriorityValue(String priority) {

        if (priority.equalsIgnoreCase("High")) {
            return 1;
        } else if (priority.equalsIgnoreCase("Medium")) {
            return 2;
        } else if (priority.equalsIgnoreCase("Low")) {
            return 3;
        }

        return 4;
    }

    public void sortByDueDate() {

        try {

            tasks.sort(Comparator.comparing(
                    task -> LocalDate.parse(
                            task.dueDate,
                            dateFormatter
                    )
            ));

            System.out.println("\nTasks sorted by due date:");
            viewTasks();

        } catch (Exception e) {

            System.out.println(
                    "Unable to sort by due date. Check date format."
            );
        }
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

    private void saveTasks() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {

            for (Task task : tasks) {

                writer.write(
                        task.name + "|" +
                        task.priority + "|" +
                        task.dueDate + "|" +
                        task.completed
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving tasks: " + e.getMessage()
            );
        }
    }

    private void loadTasks() {

        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    String name = data[0];
                    String priority = data[1];
                    String dueDate = data[2];
                    boolean completed =
                            Boolean.parseBoolean(data[3]);

                    tasks.add(
                            new Task(
                                    name,
                                    priority,
                                    dueDate,
                                    completed
                            )
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading tasks: " + e.getMessage()
            );
        }
    }
}