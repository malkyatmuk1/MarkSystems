package bg.pu.panels.teacher;

import bg.pu.service.DataService;

import javax.swing.*;

public class TeacherPanel extends JPanel {
  DataService dataService = new DataService();

  public TeacherPanel(int updateIndex) {

    UpdateTeacherPanel updateTeacherPanel =
        new UpdateTeacherPanel(dataService.getAllTeachers().get(updateIndex), this);
    TeacherTablePanel tablePanel = new TeacherTablePanel(this);
    this.add(tablePanel);
    this.add(updateTeacherPanel);
    this.add(new AddTeacherPanel(this));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
