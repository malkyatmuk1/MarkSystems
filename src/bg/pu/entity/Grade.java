package bg.pu.entity;

public class Grade {
    int gradeId;
    Float gradeValue;
    Subjects subject;
    Student student;

    public Grade(int gradeId, Float gradeValue, Subjects subject, Student student) {
        this.gradeId = gradeId;
        this.gradeValue = gradeValue;
        this.subject = subject;
        this.student = student;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Float getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Float gradeValue) {
        this.gradeValue = gradeValue;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeValue=" + gradeValue +
                ", subject=" + subject +
                ", student=" + student +
                '}';
    }
}
