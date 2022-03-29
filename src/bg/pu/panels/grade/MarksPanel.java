package bg.pu.panels.grade;

import bg.pu.entity.Student;
import bg.pu.service.DataService;

import javax.swing.*;

public class MarksPanel extends JPanel {
  private DataService dataService = new DataService();
  Student student;

  public MarksPanel(Student student, int updateIndex) {
    UpdateGradePanel updateGradePanel = new UpdateGradePanel(student, this, updateIndex);
    MarkTablePanel markTablePanel = new MarkTablePanel(student, this);
    this.add(new ChooseStudentMarkPanel(student.getStudentId(), this));
    this.add(markTablePanel);
    this.add(updateGradePanel);
    this.add(new AddGradePanel(student, this));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
