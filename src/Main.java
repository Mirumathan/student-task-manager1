import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.print("How many tasks do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            String task = sc.nextLine();
            tasks.add(task);
        }

        System.out.println("\nYour Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("\nEnter task number to delete: ");
        int deleteTask = sc.nextInt();

        if (deleteTask >= 1 && deleteTask <= tasks.size()) {

            String removedTask = tasks.remove(deleteTask - 1);

            System.out.println("Deleted task: " + removedTask);

        } else {
            System.out.println("Invalid task number!");
        }

        System.out.println("\nTasks after deletion:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        sc.close();
    }
}