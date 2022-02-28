package bg.pu.entity;

public class StudentWithGrade {
  Student student;
  float grade;
  String subjectName;

  public StudentWithGrade(Student student, float grade, String subjectName) {
    this.student = student;
    this.grade = grade;
    this.subjectName = subjectName;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public float getGrade() {
    return grade;
  }

  public void setGrade(float grade) {
    this.grade = grade;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }
}
