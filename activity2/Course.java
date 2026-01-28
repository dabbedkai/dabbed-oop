package activity2;



public class Course {

    String courseCode, courseTitle;
    Student[] enrolledStudents;

    int enrollmentCount = 0;
    static String schoolName = "Lorma University";

    public Course(){}

    public static String getSchoolName() {
        return schoolName;
    }

    public Course(String courseCode, String courseTitle){
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.enrolledStudents = new Student[50];
    }

    public void enrollStudent(Student student){
        if (enrollmentCount < enrolledStudents.length) {
            enrolledStudents[enrollmentCount] = student;
            enrollmentCount++;
        } else {
            System.out.println("Enrollment full. Cannot enroll more students.");
        }
    }

    public void displayCourseInfo(){
        System.out.println("School Name: " + getSchoolName());
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Title: " + courseTitle);
        System.out.println("Enrolled Students: " + enrollmentCount);

        if (enrollmentCount > 0) {
            for (int i = 0; i < enrollmentCount; i++) {
                System.out.println("Student " + (i + 1) + ": " + enrolledStudents[i].getFullName());
            }
        } else {
            System.out.println("No students enrolled yet.");
        }
    }
}


