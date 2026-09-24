import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your task: ");
        String task = sc.nextLine();

        System.out.println("Task added successfully!");
        System.out.println("Your task: " + task);

        sc.close();
    }
}