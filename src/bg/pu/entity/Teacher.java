package bg.pu.entity;

public class Teacher {

  int teacherId;
  String firstName;
  String secondName;
  String thirdName;

  public Teacher(int teacherId, String firstName, String secondName, String thirdName) {
    this.teacherId = teacherId;
    this.firstName = firstName;
    this.secondName = secondName;
    this.thirdName = thirdName;
  }

  public int getTeacherId() {
    return teacherId;
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

  @Override
  public String toString() {
    return "bg.pu.entity.Teacher{"
        + "teacherId="
        + teacherId
        + ", firstName='"
        + firstName
        + '\''
        + ", secondName='"
        + secondName
        + '\''
        + ", thirdName='"
        + thirdName
        + '\''
        + '}';
  }
}
