package activity2;

class Student {
}

public class Course {
    String courseCode, courseTitle;
    Student[] enrolledtStudents;

    int enrollmentCount = 0;
    static String schoolName = "Lorma University";

    public Course(){}
    public Course(String courseCode, String courseTitle){
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.enrolledtStudents = new Student[50];
    }

    public void enrollStudent(Student student){

    }
}
