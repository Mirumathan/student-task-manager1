import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.print("How many tasks do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        // Add tasks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            String task = sc.nextLine();
            tasks.add(task);
        }

        // Display tasks
        System.out.println("\nYour Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        // Update task
        System.out.print("\nEnter task number to update: ");
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

        // Display updated tasks
        System.out.println("\nUpdated Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        sc.close();
    }
}