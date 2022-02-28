package bg.pu.entity;

public class SubjectClass {
  int subjectClassId;
  Subjects subject;
  ClassOfStudents classOfStudents;

  public SubjectClass(int subjectClassId, Subjects subject, ClassOfStudents classOfStudents) {
    this.subjectClassId = subjectClassId;
    this.subject = subject;
    this.classOfStudents = classOfStudents;
  }

  public int getSubjectClassId() {
    return subjectClassId;
  }

  public void setSubjectClassId(int subjectClassId) {
    this.subjectClassId = subjectClassId;
  }

  public Subjects getSubject() {
    return subject;
  }

  public void setSubject(Subjects subject) {
    this.subject = subject;
  }

  public ClassOfStudents getClassId() {
    return classOfStudents;
  }

  public void setClassId(ClassOfStudents classId) {
    this.classOfStudents = classId;
  }

  @Override
  public String toString() {
    return "SubjectClass{"
        + "subjectClassId="
        + subjectClassId
        + ", subject="
        + subject
        + ", class="
        + classOfStudents
        + '}';
  }
}
