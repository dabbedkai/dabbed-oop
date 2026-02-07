import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    public Student() {
    }

    public Student(String firstName, String lastName, String studentId, String email) {
    }

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {


            System.out.println("\n===== GRADING MENU =====");
            System.out.println("1. ADD NEW STUDENT");
            System.out.println("2. VIEW STUDENTS LIST");
            System.out.println("3. REMOVE STUDENT");
            System.out.println("4. EXIT");
            System.out.print("CHOOSE AN OPTION: ");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":

                    System.out.print("ENTER THE STUDENT NAME YOU WANT TO ADD: ");

                    String newStudent = scanner.nextLine();
                    
                    tasks.add(newStudent);
                    System.out.println("STUDENT ADDED SUCCESSFULLY!");
                    break;

                case "2":
                    System.out.println("\n--- YOUR STUDENT LIST ---");
                    if (tasks.isEmpty()) {
                        System.out.println("YOUR STUDENT LIST IS EMPTY, ADD A STUDENT!");
                    } else {
                        
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }

                    }
                    break;

                case "3":
                    System.out.println("\nWHICH STUDENT DO YOU WANT TO REMOVE?");

                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }

                    System.out.print("ENTER THE NUMBER OF THE STUDENT TO REMOVE: ");

                    String taskNumberInput = scanner.nextLine();
                    int taskIndex = Integer.parseInt(taskNumberInput) - 1;

                   
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        tasks.remove(taskIndex);
                        System.out.println("STUDENT REMOVED SUCCESSFULLY!");
                    } else {
                        System.out.println("INVALID STUDENT NUMBER.");
                    }
                    break;

                case "4":
                    isRunning = false;
                    System.out.println("THANK YOU FOR USING THE STUDENT MANAGEMENT SYSTEM!");
                    break;

            }
        }

        scanner.close();
    }
}