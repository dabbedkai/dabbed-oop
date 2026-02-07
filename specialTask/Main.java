package activity2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import activity2.Course;

public class Main {
    public static void main(String[] args) {

        List<List<String>> student = new ArrayList<List<String>>();

        int studentCounter = 0;

        StringBuilder sb = new StringBuilder();

        System.out.println("School Name: " + Course.getSchoolName() + "\n");
        // System.out.println("Total Students at the start: " + Student.getTotalStudents());

        // Course course1 = new Course("CS101", "Introduction to Computer Science");
        // Course course2 = new Course("OOP201", "Object-Oriented Programming");
        // Course course3 = new Course("DATASTRUC301", "Data Structures and Algorithms");

        // Student student1 = new Student(101, "Kaizer", "R", "Palabay", "kaizer.palabay@gmail.com");
        // Student student2 = new Student(102, "Raizan", "N", "Palabay", "raizan.palabay@gmail.com");
        // Student student3 = new Student(103, "Zedrick", "M", "Ganaden", "zedrick.ganaden@gmail.com");

        // course1.enrollStudent(student1);
        // course1.enrollStudent(student2);
        // course1.enrollStudent(student3);
        // course2.enrollStudent(student1);
        // course2.enrollStudent(student2);
        // course3.enrollStudent(student1);
        // course3.enrollStudent(student3);
    
        // course1.displayCourseInfo();
        // System.out.println();
        // course2.displayCourseInfo();
        // System.out.println();
        // course3.displayCourseInfo(); 
        
        // System.out.println("\nTotal Students at the end: " + Student.getTotalStudents());


        Scanner sc = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {


            System.out.println("\n===== GRADING MENU =====");
            System.out.println("1. ADD NEW STUDENT");
            System.out.println("2. VIEW STUDENTS LIST");
            System.out.println("3. REMOVE STUDENT");
            System.out.println("4. EXIT");
            System.out.print("CHOOSE AN OPTION: ");

            String userInput = sc.nextLine();

            switch (userInput) {
                case "1":

                    System.out.print("ENTER THE STUDENT INFORMATION ");
                    
                    student.add(new ArrayList<String>());

                    System.out.println("ENTER STUDENT ID: ");
                    student.get(student.size() - 1).add(sc.nextLine());

                    System.out.println("ENTER FIRST NAME: ");
                    student.get(student.size() - 1).add(sc.nextLine());

                    System.out.println("ENTER MIDDLE INITIAL: ");
                    student.get(student.size() - 1).add(sc.nextLine());

                    System.out.println("ENTER LAST NAME: ");
                    student.get(student.size() - 1).add(sc.nextLine());

                    System.out.println("ENTER EMAIL ADDRESS: ");
                    student.get(student.size() - 1).add(sc.nextLine());

                    studentCounter++;
                    System.out.println("STUDENT ADDED SUCCESSFULLY!");
                    break;

                case "2":
                    System.out.println("\n--- YOUR STUDENT LIST ---");

                    if (student.isEmpty()) {

                        System.out.println("YOUR STUDENT LIST IS EMPTY, ADD A STUDENT!");

                    } else {
                        
                        for (int i = 0; i < student.size(); i++) {
                            sb.setLength(0);
                            sb.append((i + 1) + ". ");
                            sb.append("ID: " + student.get(i).get(0) + ", ");
                            sb.append("NAME: " + student.get(i).get(1) + " " + student.get(i).get(2) + " " + student.get(i).get(3) + ", ");
                            sb.append("EMAIL: " + student.get(i).get(4));
                            System.out.println(sb.toString());
                        }

                    }

                    break;

                case "3":
                    System.out.println("\nWHICH STUDENT DO YOU WANT TO REMOVE?");

                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i));
                    }

                    System.out.print("ENTER THE NUMBER OF THE STUDENT TO REMOVE: ");

                    String taskNumberInput = sc.nextLine();
                    int taskIndex = Integer.parseInt(taskNumberInput) - 1;

                   
                    if (taskIndex >= 0 && taskIndex < students.size()) {
                        students.remove(taskIndex);
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
    }
}
