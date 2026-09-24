import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {

            System.out.println("\n===== Student Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. Delete Task");
            System.out.println("6. Search Task");
            System.out.println("7. Filter by Status");
            System.out.println("8. Filter by Priority");
            System.out.println("9. Task Statistics");
            System.out.println("10. Sort Tasks");
            System.out.println("11. View Overdue Tasks");
            System.out.println("12. Exit");

            int choice = readInteger(
                    sc,
                    "Enter your choice: "
            );

            switch (choice) {

                case 1:

                    String name =
                            readNonEmptyText(
                                    sc,
                                    "Enter task: "
                            );

                    String priority =
                            readPriority(sc);

                    String dueDate =
                            readValidDate(sc);

                    manager.addTask(
                            name,
                            priority,
                            dueDate
                    );

                    break;

                case 2:

                    manager.viewTasks();
                    break;

                case 3:

                    manager.viewTasks();

                    if (!manager.tasks.isEmpty()) {

                        int updateNumber =
                                readInteger(
                                        sc,
                                        "Enter task number to update: "
                                );

                        if (updateNumber >= 1
                                && updateNumber
                                <= manager.tasks.size()) {

                            String newName =
                                    readNonEmptyText(
                                            sc,
                                            "Enter new task: "
                                    );

                            String newPriority =
                                    readPriority(sc);

                            String newDueDate =
                                    readValidDate(sc);

                            manager.updateTask(
                                    updateNumber,
                                    newName,
                                    newPriority,
                                    newDueDate
                            );
                        }
                    }

                    break;

                case 4:

                    int completeNumber =
                            readInteger(
                                    sc,
                                    "Enter task number to complete: "
                            );

                    manager.completeTask(
                            completeNumber
                    );

                    break;

                case 5:

                    int deleteNumber =
                            readInteger(
                                    sc,
                                    "Enter task number to delete: "
                            );

                    manager.deleteTask(
                            deleteNumber
                    );

                    break;

                case 6:

                    String keyword =
                            readNonEmptyText(
                                    sc,
                                    "Enter task to search: "
                            );

                    manager.searchTask(keyword);

                    break;

                case 7:

                    System.out.println("\n1. Pending");
                    System.out.println("2. Completed");

                    int statusChoice =
                            readInteger(
                                    sc,
                                    "Choose status: "
                            );

                    if (statusChoice == 1) {

                        manager.filterByStatus(
                                "Pending"
                        );

                    } else if (statusChoice == 2) {

                        manager.filterByStatus(
                                "Completed"
                        );

                    } else {

                        System.out.println(
                                "Invalid choice!"
                        );
                    }

                    break;

                case 8:

                    System.out.println("\n1. High");
                    System.out.println("2. Medium");
                    System.out.println("3. Low");

                    int priorityChoice =
                            readInteger(
                                    sc,
                                    "Choose priority: "
                            );

                    if (priorityChoice == 1) {

                        manager.filterByPriority(
                                "High"
                        );

                    } else if (priorityChoice == 2) {

                        manager.filterByPriority(
                                "Medium"
                        );

                    } else if (priorityChoice == 3) {

                        manager.filterByPriority(
                                "Low"
                        );

                    } else {

                        System.out.println(
                                "Invalid choice!"
                        );
                    }

                    break;

                case 9:

                    manager.showStatistics();
                    break;

                case 10:

                    System.out.println(
                            "\n===== Sort Tasks ====="
                    );
                    System.out.println(
                            "1. Sort by Priority"
                    );
                    System.out.println(
                            "2. Sort by Due Date"
                    );

                    int sortChoice =
                            readInteger(
                                    sc,
                                    "Choose option: "
                            );

                    if (sortChoice == 1) {

                        manager.sortByPriority();

                    } else if (sortChoice == 2) {

                        manager.sortByDueDate();

                    } else {

                        System.out.println(
                                "Invalid choice!"
                        );
                    }

                    break;

                case 11:

                    manager.showOverdueTasks();
                    break;

                case 12:

                    System.out.println(
                            "Thank you for using Student Task Manager!"
                    );

                    sc.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice! Enter 1 to 12."
                    );
            }
        }
    }

    public static int readInteger(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    sc.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number!"
                );
            }
        }
    }

    public static String readNonEmptyText(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty!"
            );
        }
    }

    public static String readPriority(
            Scanner sc) {

        while (true) {

            System.out.print(
                    "Enter priority (High/Medium/Low): "
            );

            String priority =
                    sc.nextLine().trim();

            if (priority.equalsIgnoreCase("High")) {
                return "High";
            }

            if (priority.equalsIgnoreCase("Medium")) {
                return "Medium";
            }

            if (priority.equalsIgnoreCase("Low")) {
                return "Low";
            }

            System.out.println(
                    "Invalid priority! Please enter High, Medium or Low."
            );
        }
    }

    public static String readValidDate(
            Scanner sc) {

        while (true) {

            System.out.print(
                    "Enter due date (DD-MM-YYYY): "
            );

            String dueDate =
                    sc.nextLine().trim();

            if (managerDateIsValid(dueDate)) {
                return dueDate;
            }

            System.out.println(
                    "Invalid date! Please use DD-MM-YYYY."
            );
        }
    }

    public static boolean managerDateIsValid(
            String dueDate) {

        String[] parts =
                dueDate.split("-");

        if (parts.length != 3) {
            return false;
        }

        try {

            int day =
                    Integer.parseInt(parts[0]);

            int month =
                    Integer.parseInt(parts[1]);

            int year =
                    Integer.parseInt(parts[2]);

            if (day < 1 || day > 31) {
                return false;
            }

            if (month < 1 || month > 12) {
                return false;
            }

            if (year < 2000 || year > 2100) {
                return false;
            }

            java.time.LocalDate.parse(
                    dueDate,
                    java.time.format.DateTimeFormatter
                            .ofPattern("dd-MM-yyyy")
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}