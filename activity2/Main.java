package activity2;

public class Main {
    public static void main(String[] args) {

        System.out.println("School Name: " + Course.getSchoolName() + "\n");
        System.out.println("Total Students at the start: " + Student.getTotalStudents());

        Course course1 = new Course("CS101", "Introduction to Computer Science");
        Course course2 = new Course("OOP201", "Object-Oriented Programming");
        Course course3 = new Course("DATASTRUC301", "Data Structures and Algorithms");

        Student student1 = new Student(101, "Kaizer", 'R', "Palabay", "Male", "kaizer.palabay@gmail.com");
        Student student2 = new Student(102, "Raizan", 'N', "Palabay", "Female", "raizan.palabay@gmail.com");
        Student student3 = new Student(103, "Zedrick", 'M', "Ganaden", "Male", "zedrick.ganaden@gmail.com");

        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student3);
        course2.enrollStudent(student1);
        course2.enrollStudent(student2);
        course3.enrollStudent(student1);
        course3.enrollStudent(student3);
    
        course1.displayCourseInfo();
        System.out.println();
        course2.displayCourseInfo();
        System.out.println();
        course3.displayCourseInfo(); 
        
        System.out.println("\nTotal Students at the end: " + Student.getTotalStudents());
    }
}
