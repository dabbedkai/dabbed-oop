package activity2;

public class Student {

    int studentId;
    String firstName, lastName, gender, email;
    char middleName;
    static int totalStudents = 0;

    Student[] studentList;

    public Student(){}

    public Student(int studentId, String firstName, char middleName, String lastName, String gender, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;

        Student.totalStudents++;
    }

    public void displayStudentInfo(){
        for (Student p : studentList) {
            System.out.println("Student Name: " + p.getFullName());
            System.out.println("Student ID: " + p.getId());
            System.out.println("Student Gender: " + p.getGender());
            System.out.println("Student Email: " + p.getEmail());
        }   
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public String getFullName(){
        return firstName + " " + middleName + " " + lastName;
    }

    public int getId() {
        return studentId;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
}

    
