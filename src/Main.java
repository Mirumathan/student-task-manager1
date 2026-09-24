import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String taskName = sc.nextLine();

                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    tasks.add(new Task(taskName, priority));

                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {

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
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    System.out.print("Enter task number to complete: ");
                    int taskNumber = sc.nextInt();

                    if (taskNumber >= 1 && taskNumber <= tasks.size()) {

                        tasks.get(taskNumber - 1).markCompleted();

                        System.out.println("Task marked as completed!");

                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    System.out.print("Enter task number to delete: ");
                    int deleteNumber = sc.nextInt();

                    if (deleteNumber >= 1 && deleteNumber <= tasks.size()) {

                        Task removedTask = tasks.remove(deleteNumber - 1);

                        System.out.println(
                            "Deleted task: " + removedTask.name
                        );

                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Student Task Manager!"
                    );

                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}