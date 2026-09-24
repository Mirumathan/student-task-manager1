import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");

                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }

                    System.out.print("Enter task number to update: ");
                    int updateTask = sc.nextInt();
                    sc.nextLine();

                    if (updateTask >= 1 && updateTask <= tasks.size()) {
                        System.out.print("Enter new task: ");
                        String newTask = sc.nextLine();

                        tasks.set(updateTask - 1, newTask);
                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    System.out.println("\nYour Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }

                    System.out.print("Enter task number to delete: ");
                    int deleteTask = sc.nextInt();

                    if (deleteTask >= 1 && deleteTask <= tasks.size()) {
                        String removedTask = tasks.remove(deleteTask - 1);
                        System.out.println("Deleted task: " + removedTask);
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Student Task Manager!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}