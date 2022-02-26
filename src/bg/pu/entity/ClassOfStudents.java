package bg.pu.entity;

public class ClassOfStudents {
    int classId;
    Teacher teacher;
    String name;

    public ClassOfStudents(int classId, Teacher teacher, String name) {
        this.classId = classId;
        this.teacher = teacher;
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassOfStudents{" +
                "classId=" + classId +
                ", teacher=" + teacher +
                ", name='" + name + '\'' +
                '}';
    }
}
