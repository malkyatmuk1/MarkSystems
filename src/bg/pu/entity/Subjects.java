package bg.pu.entity;

public class Subjects {

    int subjectId;
    String name;

    public Subjects(int subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "bg.pu.entity.Subjects{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                '}';
    }
}
