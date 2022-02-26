package bg.pu.entity;

public class Student {
    int studentId;
    String firstName;
    String secondName;
    String thirdName;
    ClassOfStudents classStudent;

    public Student(int studentId, String firstName, String secondName, String thirdName, ClassOfStudents classStudent) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.classStudent = classStudent;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public ClassOfStudents getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(ClassOfStudents classStudent) {
        this.classStudent = classStudent;
    }

    @Override
    public String toString() {
        return "bg.pu.entity.Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", classStudent=" + classStudent +
                '}';
    }
}
