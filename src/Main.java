import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {

            System.out.println("\n===== Student Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String name = sc.nextLine();

                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    System.out.print("Enter due date (DD-MM-YYYY): ");
                    String dueDate = sc.nextLine();

                    manager.addTask(name, priority, dueDate);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter task number to complete: ");
                    int completeNumber = sc.nextInt();

                    manager.completeTask(completeNumber);
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int deleteNumber = sc.nextInt();

                    manager.deleteTask(deleteNumber);
                    break;

                case 5:
                    System.out.print("Enter task to search: ");
                    String keyword = sc.nextLine();

                    manager.searchTask(keyword);
                    break;

                case 6:
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